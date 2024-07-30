package AST;

public class AST_DEC_LIST extends AST_Node {
    /****************/
    /* DATA MEMBERS */
    /****************/
    public AST_DEC d;
    public AST_DEC_LIST dl;

    /******************/
    /* CONSTRUCTOR(S) */
    /******************/
    public AST_DEC_LIST(AST_DEC d, AST_DEC_LIST dl) {
        /******************************/
        /* SET A UNIQUE SERIAL NUMBER */
        /******************************/
        SerialNumber = AST_Node_Serial_Number.getFresh();

        /***************************************/
        /* PRINT CORRESPONDING DERIVATION RULE */
        /***************************************/
        if (dl != null)
            System.out.print("====================== decs -> dec decs\n");
        if (dl == null)
            System.out.print("====================== decs -> dec      \n");

        /*******************************/
        /* COPY INPUT DATA NENBERS ... */
        /*******************************/
        this.d = d;
        this.dl = dl;
    }

    /******************************************************/
    /* The printing message for a statement list AST node */
    /******************************************************/
    public void PrintMe() {
        /**************************************/
        /* AST NODE TYPE = AST STATEMENT LIST */
        /**************************************/
        System.out.print("AST NODE DEC LIST\n");

        /*************************************/
        /* RECURSIVELY PRINT HEAD + TAIL ... */
        /*************************************/
        if (d != null)
            d.PrintMe();
        if (dl != null)
            dl.PrintMe();

        /**********************************/
        /* PRINT to AST GRAPHVIZ DOT file */
        /**********************************/

        AST_GRAPHVIZ.getInstance().logNode(
                SerialNumber,
                "AST\nDEC\nLIST\n");

        /****************************************/
        /* PRINT Edges to AST GRAPHVIZ DOT file */
        /****************************************/
        if (d != null)
            AST_GRAPHVIZ.getInstance().logEdge(SerialNumber, d.SerialNumber);
        if (dl != null)
            AST_GRAPHVIZ.getInstance().logEdge(SerialNumber, dl.SerialNumber);
    }
}
