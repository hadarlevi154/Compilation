package AST;

public class AST_EXP_NEWEXP_NEWEXP extends AST_EXP_NEWEXP{
    AST_TYPE type;
    AST_EXP exp;

    /******************/
    /* CONSTRUCTOR(S) */
    /******************/
    public AST_EXP_NEWEXP_NEWEXP(AST_TYPE type, AST_EXP exp)
    {

        /******************************/
        /* SET A UNIQUE SERIAL NUMBER */
        /******************************/
        SerialNumber = AST_Node_Serial_Number.getFresh();

        /***************************************/
        /* PRINT CORRESPONDING DERIVATION RULE */
        /***************************************/
        System.out.format("====================== newExp -> NEW ID( %s )\n", type);
        System.out.format("====================== newExp -> NEW ID( %s ) [exp]\n", type);

        /*******************************/
        /* COPY INPUT DATA MEMBERS ... */
        /*******************************/
        this.type = type;
        this.exp = exp;
    }

    /*************************************************/
    /* The printing message for a newExp new AST node */
    /*************************************************/
    public void PrintMe()
    {
        /*********************************/
        /* AST NODE TYPE = AST NEWEXP NEW */
        /*********************************/
        System.out.print("AST NODE NEWEXP NEW\n");

        /**********************************************/
        /* , PRINT CLASS NAME then RECURSIVELY PRINT EXP ... */
        /**********************************************/
        System.out.format("TYPE( %s )\n",type);
        if (exp != null) exp.PrintMe();

        /***************************************/
        /* PRINT Node to AST GRAPHVIZ DOT file */
        /***************************************/
        AST_GRAPHVIZ.getInstance().logNode(
            SerialNumber,
            String.format("AST\nNEWEXP\nNEWEXP\n...->##%s##",type));

        /****************************************/
        /* PRINT Edges to AST GRAPHVIZ DOT file */
        /****************************************/
        if (exp != null) AST_GRAPHVIZ.getInstance().logEdge(SerialNumber,exp.SerialNumber);
    }

}
