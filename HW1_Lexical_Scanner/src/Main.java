   
import java.io.*;
import java.io.PrintWriter;

import java_cup.runtime.Symbol;
   
public class Main
{
	static public void main(String argv[])
	{
		Lexer l;
		Symbol s;
		FileReader file_reader;
		PrintWriter file_writer;
		String inputFilename = argv[0];
		String outputFilename = argv[1];
		
		try
		{
			/********************************/
			/* [1] Initialize a file reader */
			/********************************/
			file_reader = new FileReader(inputFilename);

			/********************************/
			/* [2] Initialize a file writer */
			/********************************/
			file_writer = new PrintWriter(outputFilename);
			
			/******************************/
			/* [3] Initialize a new lexer */
			/******************************/
			l = new Lexer(file_reader);

			/***********************/
			/* [4] Read next token */
			/***********************/
			s = l.next_token();

			/********************************/
			/* [5] Main reading tokens loop */
			/********************************/
			while (s.sym != TokenNames.EOF)
			{
				/************************/
				/* [6] Print to console */
				/************************/
                String token = getToken(s.sym, s.value);
                if(token.equals("ERROR")){
                    file_writer = new PrintWriter(outputFilename);
                    file_writer.print("");
                    file_writer.print("ERROR");
                    file_writer.close();
                    System.out.println("ERROR");
                    return;
                }
                System.out.print(token);
				System.out.print("[");
				System.out.print(l.getLine());
				System.out.print(",");
				System.out.print(l.getTokenStartPosition());
				System.out.print("]:");
				System.out.print(s.value);
				System.out.print("\n");
				
				/*********************/
				/* [7] Print to file */
				/*********************/
                file_writer.print(token);
                file_writer.print("[");
                file_writer.print(l.getLine());
                file_writer.print(",");
                file_writer.print(l.getTokenStartPosition());
                file_writer.print("]");
				
				/***********************/
				/* [8] Read next token */
				/***********************/
				s = l.next_token();
                if(s.sym != TokenNames.EOF){
                    file_writer.print("\n");
                }
			}
			
			/******************************/
			/* [9] Close lexer input file */
			/******************************/
			l.yyclose();

			/**************************/
			/* [10] Close output file */
			/**************************/
			file_writer.close();
    	}
			     
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

    private static String getToken(int tokenNumber, Object value){
        String result;
        switch (tokenNumber) {
            case TokenNames.PLUS:
                result = "PLUS";
                break;
            case TokenNames.MINUS:
                result = "MINUS";
                break;
            case TokenNames.TIMES:
                result = "TIMES";
                break;
            case TokenNames.DIVIDE:
                result = "DIVIDE";
                break;
            case TokenNames.LPAREN:
                result = "LPAREN";
                break;
            case TokenNames.RPAREN:
                result = "RPAREN";
                break;
            case TokenNames.NUMBER:
                if (0 > (int) value || (int) value > (Math.pow(2, 15)-1)) {
                    result = "ERROR";
                    break;
                }
                result = "INT(" + value + ")";//***************************************************
                break;
            case TokenNames.LBRACK:
                result = "LBRACK";
                break;
            case TokenNames.RBRACK:
                result = "RBRACK";
                break;
            case TokenNames.LBRACE:
                result = "LBRACE";
                break;
            case TokenNames.RBRACE:
                result = "RBRACE";
                break;
            case TokenNames.NIL:
                result = "NIL";
                break;
            case TokenNames.COMMA:
                result = "COMMA";
                break;
            case TokenNames.DOT:
                result = "DOT";
                break;
            case TokenNames.SEMICOLON:
                result = "SEMICOLON";
                break;
            case TokenNames.ASSIGN:
                result = "ASSIGN";
                break;
            case TokenNames.EQ:
                result = "EQ";
                break;
            case TokenNames.LT:
                result = "LT";
                break;
            case TokenNames.GT:
                result = "GT";
                break;
            case TokenNames.ARRAY:
                result = "ARRAY";
                break;
            case TokenNames.CLASS:
                result = "CLASS";
                break;
            case TokenNames.EXTENDS:
                result = "EXTENDS";
                break;
            case TokenNames.RETURN:
                result = "RETURN";
                break;
            case TokenNames.WHILE:
                result = "WHILE";
                break;
            case TokenNames.IF:
                result = "IF";
                break;
            case TokenNames.NEW:
                result = "NEW";
                break;
            case TokenNames.STRING:
                result = "STRING(" + value + ")";
                break;
            case TokenNames.ID:
                result = "ID(" + value + ")";
                break;
            case TokenNames.TYPE_INT:
                result = "TYPE_INT";
                break;
            case TokenNames.TYPE_STRING:
                result = "TYPE_STRING";
                break;
            case TokenNames.TYPE_VOID:
                result = "TYPE_VOID";
                break;
            default:
                result = "ERROR";
        }
        return result;
    }
}

