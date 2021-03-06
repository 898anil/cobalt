package compiler.parser.structures

import java.util.{ArrayList, List}

import compiler.block.Block
import compiler.block.structures.objects.ObjectBlock
import compiler.parser.Parser
import compiler.structure.parameters.Parameter
import compiler.tokenizer.Tokenizer

/**
  * Creation of a new instance of a class
  */
class ObjectParser extends Parser[ObjectBlock] {
  def shouldParse(line: String): Boolean = line.matches("var[ ]+[a-zA-Z][a-zA-Z0-9]*[ ]*:[a-zA-Z][a-zA-Z0-9]*[ ]*[=][ ]*new[ ]*[a-zA-Z][a-zA-Z0-9]*\\((.*)*\\)[ ]*")

  def parse(superBlock: Block, tokenizer: Tokenizer): ObjectBlock = {
    tokenizer.nextToken // skip "var"
    val variableName: String = tokenizer.nextToken.token
    tokenizer.nextToken // skip ":"
    val className: String = tokenizer.nextToken.token
    val operator: String = tokenizer.nextToken.token
    val newKeyword: String = tokenizer.nextToken.token
    val initClassName: String = tokenizer.nextToken.token

    tokenizer.nextToken // skip "("

    var nextToken: String = tokenizer.nextToken.token
    val paramType: String = ""
    var paramName: String = ""
    val parameters: List[Parameter] = new ArrayList[Parameter]
    while (nextToken != ")") {
      {

        if (nextToken == ",") {
          nextToken = tokenizer.nextToken.token
        } else {
          paramName = nextToken.trim
          parameters.add(new Parameter(paramType, paramName))
          nextToken = tokenizer.nextToken.token
        }
      }
    }
    return new ObjectBlock(superBlock, className, variableName, operator, newKeyword, initClassName, parameters.toArray(new Array[Parameter](parameters.size)))
  }
}
