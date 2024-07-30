package AST;

public class AST_CLASSDEC_CFIELD extends AST_CLASSDEC{
    String name;
    String parentName;
    AST_CFIELD_LIST cfl;

    /******/
    /* CONSTRUCTOR(S) */
    /******/
    public AST_CLASSDEC_CFIELD(String name, String parentName, AST_CFIELD_LIST cfl)
    {
        /**********/
        /* SET A UNIQUE SERIAL NUMBER */
        /**********/
        SerialNumber = AST_Node_Serial_Number.getFresh();

        /*************/
        /* PRINT CORRESPONDING DERIVATION RULE */
        /*************/
        System.out.format("====================== classDec -> CLASS ID( %s )[extends ID( %s )] {cFields}\n", name, parentName != null ? parentName : "");

        /***********/
        /* COPY INPUT DATA MEMBERS ... */
        /***********/
        this.name = name;
        this.parentName = parentName;
        this.cfl = cfl;
    }

    /*****************/
    /* The printing message for class dec cField AST node */
    /*****************/
    public void PrintMe()
    {
        /*************/
        /* AST NODE TYPE = AST CLASSDEC CFIELD */
        /*************/
        System.out.print("AST NODE CLASSDEC CFIELD\n");

        /**************/
        /* RECURSIVELY PRINT name + parentName + cfl ... */
        /**************/
        System.out.format("CLASS NAME( %s )\n", name);
        if (parentName != null) System.out.format("PARENT CLASS NAME( %s )\n", parentName);
        if (cfl != null) cfl.PrintMe();

        /*************/
        /* PRINT Node to AST GRAPHVIZ DOT file */
        /*************/
        AST_GRAPHVIZ.getInstance().logNode(
            SerialNumber,
            String.format("CLASS\n(%s)",name));
        if (parentName != null) AST_GRAPHVIZ.getInstance().logNode(SerialNumber,String.format("PARENT\nCLASS\n(%s)",parentName));

        /**************/
        /* PRINT Edges to AST GRAPHVIZ DOT file */
        /**************/
        if (cfl != null) AST_GRAPHVIZ.getInstance().logEdge(SerialNumber,cfl.SerialNumber);
    }

}
