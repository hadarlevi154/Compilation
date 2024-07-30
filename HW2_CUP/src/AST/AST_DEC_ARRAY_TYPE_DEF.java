package AST;

public class AST_DEC_ARRAY_TYPE_DEF extends AST_DEC{
    public AST_ARRAY_TYPE_DEF atd;

    /******************/
    /* CONSTRUCTOR(S) */
    /******************/
    public AST_DEC_ARRAY_TYPE_DEF(AST_ARRAY_TYPE_DEF atd)
    {
        /******************************/
        /* SET A UNIQUE SERIAL NUMBER */
        /******************************/
        SerialNumber = AST_Node_Serial_Number.getFresh();

        /***************************************/
        /* PRINT ARRAYTYPEDEF RULE */
        /***************************************/
        System.out.print("====================== dec -> arrayTypedef\n");

        /*******************************/
        /* COPY INPUT DATA NENBERS ... */
        /*******************************/
        this.atd = atd;
    }

    /***********************************************/
    /* The default message for an ARRAYTYPEDEF AST node */
    /***********************************************/
    public void PrintMe()
    {
        /************************************/
        /* AST NODE TYPE = ARRAYTYPEDEF AST NODE */
        /************************************/
        System.out.print("AST NODE ARRAYTYPEDEF\n");

        /*****************************/
        /* RECURSIVELY PRINT var ... */
        /*****************************/
        if (atd != null) atd.PrintMe();

        /*********************************/
        /* Print to AST GRAPHIZ DOT file */
        /*********************************/
        AST_GRAPHVIZ.getInstance().logNode(
                SerialNumber,
                "AST\nDEC\nARRAYTYPEDEF");

        /****************************************/
        /* PRINT Edges to AST GRAPHVIZ DOT file */
        /****************************************/
        AST_GRAPHVIZ.getInstance().logEdge(SerialNumber,atd.SerialNumber);

    }
}
