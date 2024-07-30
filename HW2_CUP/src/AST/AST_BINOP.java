package AST;

public class AST_BINOP extends AST_Node{
    int OP;

    /******************/
    /* CONSTRUCTOR(S) */
    /******************/
    public AST_BINOP(int OP)
    {
        /******************************/
        /* SET A UNIQUE SERIAL NUMBER */
        /******************************/
        SerialNumber = AST_Node_Serial_Number.getFresh();

        /***************************************/
        /* PRINT CORRESPONDING DERIVATION RULE */
        /***************************************/
        System.out.print("====================== BINOP -> BINOP \n");

        /*******************************/
        /* COPY INPUT DATA NENBERS ... */
        /*******************************/
        this.OP = OP;
    }

    /*************************************************/
    /* The printing message for a binop exp AST node */
    /*************************************************/
    public void PrintMe()
    {
        String sOP="";

        /*********************************/
        /* CONVERT OP to a printable sOP */
        /*********************************/
        switch (OP) {
            case 0:
                sOP = "+";
                break;
            case 1:
                sOP = "-";
                break;
            case 2:
                sOP = "*";
                break;
            case 3:
                sOP = "/";
                break;
            case 4:
                sOP = "<";
                break;
            case 5:
                sOP = ">";
                break;
            case 6:
                sOP = "=";
                break;
        }

        /*************************************/
        /* AST NODE TYPE = AST BINOP EXP */
        /*************************************/
        System.out.print("AST NODE BINOP\n");


        /***************************************/
        /* PRINT Node to AST GRAPHVIZ DOT file */
        /***************************************/
        AST_GRAPHVIZ.getInstance().logNode(
            SerialNumber,
            String.format("BINOP(%s)",sOP));

    }
}
