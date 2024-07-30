package AST;

public class AST_FUNC_DEC_STMT extends AST_FUNC_DEC {

    AST_TYPE type;
    String funcName;
    AST_TYPEID_LIST til;
    AST_STMT_LIST sl;

    /******/
    /* CONSTRUCTOR(S) */
    /******/
    public AST_FUNC_DEC_STMT(AST_TYPE type, String funcName, AST_TYPEID_LIST til, AST_STMT_LIST sl)
    {
        System.out.print("---AST_FUNCDEC_STMT---");
        /**********/
        /* SET A UNIQUE SERIAL NUMBER */
        /**********/
        SerialNumber = AST_Node_Serial_Number.getFresh();

        /*************/
        /* PRINT CORRESPONDING DERIVATION RULE */
        /*************/
        System.out.format("====================== funcDec -> type ID( %s )(til) {sl}\n", funcName);

        /***********/
        /* COPY INPUT DATA MEMBERS ... */
        /***********/
        this.type = type;
        this.funcName = funcName;
        this.til = til;
        this.sl = sl;
    }

    /*****************/
    /* The printing message for class dec func AST node */
    /*****************/
    public void PrintMe()
    {
        /*************/
        /* AST NODE TYPE = AST FUNCDEC STMT */
        /*************/
        System.out.print("AST NODE FUNCDEC STMT\n");

        /**************/
        /* RECURSIVELY PRINT type + funcName + type ids list + stmt ... */
        /**************/
        if (type != null) type.PrintMe();
        System.out.format("FUNC NAME( %s )\n", funcName);
        if (til != null) til.PrintMe();
        if (sl != null) sl.PrintMe();

        /*************/
        /* PRINT Node to AST GRAPHVIZ DOT file */
        /*************/
        AST_GRAPHVIZ.getInstance().logNode(
            SerialNumber,
            String.format("AST\nFUNCDEC\nSTMT\n(%s)",funcName));

        /**************/
        /* PRINT Edges to AST GRAPHVIZ DOT file */
        /**************/
        if (type != null) AST_GRAPHVIZ.getInstance().logEdge(SerialNumber,type.SerialNumber);
        if (til != null) AST_GRAPHVIZ.getInstance().logEdge(SerialNumber,til.SerialNumber);
        if (sl != null) AST_GRAPHVIZ.getInstance().logEdge(SerialNumber,sl.SerialNumber);
    }

}
