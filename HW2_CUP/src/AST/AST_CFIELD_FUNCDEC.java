package AST;

public class AST_CFIELD_FUNCDEC extends AST_CFIELD{
    public AST_FUNC_DEC fd;

    /******************/
    /* CONSTRUCTOR(S) */
    /******************/
    public AST_CFIELD_FUNCDEC(AST_FUNC_DEC fd)
    {
        /******************************/
        /* SET A UNIQUE SERIAL NUMBER */
        /******************************/
        SerialNumber = AST_Node_Serial_Number.getFresh();

        /***************************************/
        /* PRINT FUNCDEC RULE */
        /***************************************/
        System.out.print("====================== cField -> funcDec\n\n");

        /*******************************/
        /* COPY INPUT DATA NENBERS ... */
        /*******************************/
        this.fd = fd;
    }

    /***********************************************/
    /* The default message for an CFIELD FUNCDEC AST node */
    /***********************************************/
    public void PrintMe()
    {
        /************************************/
        /* AST NODE TYPE = CFIELD FUNCDEC AST NODE */
        /************************************/
        System.out.print("AST NODE CFIELD FUNCDEC\n");

        /*****************************/
        /* RECURSIVELY PRINT var ... */
        /*****************************/
        if (fd != null) fd.PrintMe();

        /*********************************/
        /* Print to AST GRAPHIZ DOT file */
        /*********************************/
        AST_GRAPHVIZ.getInstance().logNode(
                SerialNumber,
                "AST\nCFIELD\nFUNCDEC");

        /****************************************/
        /* PRINT Edges to AST GRAPHVIZ DOT file */
        /****************************************/
        AST_GRAPHVIZ.getInstance().logEdge(SerialNumber,fd.SerialNumber);

    }
}
