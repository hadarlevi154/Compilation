package AST;

public class AST_NEWTYPE extends AST_TYPE {
    int type;
    String name;

    /******************/
    /* CONSTRUCTOR(S) */
    /******************/
    public AST_NEWTYPE(int type, String name) {
        /******************************/
        /* SET A UNIQUE SERIAL NUMBER */
        /******************************/
        SerialNumber = AST_Node_Serial_Number.getFresh();

        /***************************************/
        /* PRINT CORRESPONDING DERIVATION RULE */
        /***************************************/
        System.out.print("====================== type -> type \n");

        /*******************************/
        /* COPY INPUT DATA NENBERS ... */
        /*******************************/
        this.type = type;
        this.name = name;
    }

    /*************************************************/
    /* The printing message for a binop exp AST node */
    /*************************************************/
    public void PrintMe() {
        String sOP = "";

        /*********************************/
        /* CONVERT OP to a printable sOP */
        /*********************************/
        if (type == 0) {
            sOP = "int";
        }
        if (type == 1) {
            sOP = "string";
        }
        if (type == 2) {
            sOP = "void";
        }
        if (type == 3) {
            sOP = "id";
        }

        /*************************************/
        /* AST NODE TYPE = AST TYPE */
        /*************************************/
        System.out.print("AST NODE TYPE\n");

        /***************************************/
        /* PRINT Node to AST GRAPHVIZ DOT file */
        /***************************************/
        if (this.name != null) {
            AST_GRAPHVIZ.getInstance().logNode(
                    SerialNumber,
                    String.format("TYPE(%s),(%s)", sOP, this.name));
        } else {
            AST_GRAPHVIZ.getInstance().logNode(
                    SerialNumber,
                    String.format("TYPE(%s)", sOP));
        }
    }
}
