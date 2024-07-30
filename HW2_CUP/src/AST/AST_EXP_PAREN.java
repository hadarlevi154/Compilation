package AST;

public class AST_EXP_PAREN extends AST_EXP{

    public AST_EXP e;

    public AST_EXP_PAREN(AST_EXP e)
    {
        /******************************/
        /* SET A UNIQUE SERIAL NUMBER */
        /******************************/
        SerialNumber = AST_Node_Serial_Number.getFresh();

        /***************************************/
        /* PRINT CORRESPONDING DERIVATION RULE */
        /***************************************/
        System.out.print("====================== exp -> (exp)\n");

        /*******************************/
        /* COPY INPUT DATA NENBERS ... */
        /*******************************/
        this.e = e;
    }

    public void PrintMe()
    {
        /**************************************/
        /* AST NODE TYPE = AST STATEMENT LIST */
        /**************************************/
        System.out.print("AST NODE EXP_CLASS\n");

        /*************************************/
        /* RECURSIVELY PRINT HEAD + TAIL ... */
        /*************************************/
        if (e != null) e.PrintMe();

        /**********************************/
        /* PRINT to AST GRAPHVIZ DOT file */
        /**********************************/
        AST_GRAPHVIZ.getInstance().logNode(
                SerialNumber,
                "AST\nEXP\nPAREN\n");

        /****************************************/
        /* PRINT Edges to AST GRAPHVIZ DOT file */
        /****************************************/
        if (e != null) AST_GRAPHVIZ.getInstance().logEdge(SerialNumber,e.SerialNumber);
    }
}
