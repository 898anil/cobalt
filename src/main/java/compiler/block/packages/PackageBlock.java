package compiler.block.packages;

import compiler.Parameter;
import compiler.block.Block;

public class PackageBlock extends Block {

    public String directory;

    public PackageBlock(String directory) {
        super(null, false, false);
        this.directory = directory;
    }

    public String getName() {
        return null;
    }

    @Override
    public String getValue() {
        return null;
    }

    public String getType() {
        return null;
    }

    @Override
    public String getOpeningCode() {
        return null;
    }

    @Override
    public String getClosingCode() {
        return null;
    }

    @Override
    public String getBodyCode() {
        return null;
    }


    @Override
    public void init() {

    }

    @Override
    public void run() {

    }

}