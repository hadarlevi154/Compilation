package AST;

public class AST_STMT_ID extends AST_STMT{
    public String name;
    public AST_VAR var;
    public AST_EXP_LIST el;

    /******/
    /* CONSTRUCTOR(S) */
    /******/
    public AST_STMT_ID(String name, AST_VAR var,AST_EXP_LIST el)
    {
        /**********/
        /* SET A UNIQUE SERIAL NUMBER */
        /**********/
        SerialNumber = AST_Node_Serial_Number.getFresh();

        /*************/
        /* PRINT CORRESPONDING DERIVATION RULE */
        /*************/
        System.out.format("====================== exp -> var.ID( %s )(exps)\n", name);

        /***********/
        /* COPY INPUT DATA MEMBERS ... */
        /***********/
        this.var = var;
        this.el = el;
        this.name = name;
    }

    /*****************/
    /* The printing message for a func exp AST node */
    /*****************/
    public void PrintMe()
    {
        /*************/
        /* AST NODE TYPE = AST STMT ID */
        /*************/
        System.out.print("AST NODE ID STMT\n");

        /**************/
        /* RECURSIVELY PRINT var + func name + el ... */
        /**************/
        if (var != null) var.PrintMe();
        System.out.format("FUNCTION NAME( %s )\n",name);
        if (el != null) el.PrintMe();

        /*************/
        /* PRINT Node to AST GRAPHVIZ DOT file */
        /*************/
        AST_GRAPHVIZ.getInstance().logNode(
            SerialNumber,
            String.format("AST\nSTMT\nID(%s)",name));

        /**************/
        /* PRINT Edges to AST GRAPHVIZ DOT file */
        /**************/
        if (var  != null) AST_GRAPHVIZ.getInstance().logEdge(SerialNumber,var.SerialNumber);
        if (el != null) AST_GRAPHVIZ.getInstance().logEdge(SerialNumber,el.SerialNumber);
    }
}
