package AST;

public class AST_PROGRAM_DEC extends AST_PROGRAM {
    public AST_DEC_LIST dl;

    /******************/
    /* CONSTRUCTOR(S) */
    /******************/
    public AST_PROGRAM_DEC(AST_DEC_LIST dl) {
        System.out.print("---PROGRAM---\n");
        /******************************/
        /* SET A UNIQUE SERIAL NUMBER */
        /******************************/
        SerialNumber = AST_Node_Serial_Number.getFresh();

        /***************************************/
        /* PRINT CORRESPONDING DERIVATION RULE */
        /***************************************/
        System.out.print("====================== Program -> dec decs\n");

        /*******************************/
        /* COPY INPUT DATA NENBERS ... */
        /*******************************/
        this.dl = dl;
    }

    /***********************************************/
    /* The default message for an program dec AST node */
    /***********************************************/
    public void PrintMe() {
        /************************************/
        /* AST NODE TYPE = PROGRAM DEC AST NODE */
        /************************************/
        System.out.print("AST NODE PROGRAM DEC\n");

        /*****************************/
        /* RECURSIVELY PRINT l ... */
        /*****************************/
        if (dl != null)
            dl.PrintMe();

        /*********************************/
        /* Print to AST GRAPHIZ DOT file */
        /*********************************/
        AST_GRAPHVIZ.getInstance().logNode(
                SerialNumber,
                "AST\nPROGRAM\nDEC");

        /****************************************/
        /* PRINT Edges to AST GRAPHVIZ DOT file */
        /****************************************/
        AST_GRAPHVIZ.getInstance().logEdge(SerialNumber, dl.SerialNumber);

    }
}
