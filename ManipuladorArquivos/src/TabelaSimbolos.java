import java.util.HashMap;

public class TabelaSimbolos {
	public HashMap<String, Simbolo> tabela = new HashMap<>();
	public static int end = -1;

	public final byte FINAL = 0;
	public final byte INT = 1;
	public final byte BYTE = 2;
	public final byte STRING = 3;
	public final byte WHILE = 4;
	public final byte IF = 5;
	public final byte ELSE = 6;
	public final byte AND = 7;
	public final byte OR = 8;
	public final byte NOT = 9;
	public final byte EQUAL = 10;
	public final byte RECIEVE = 11;
	public final byte OPPAR = 12;
	public final byte CLPAR = 13;
	public final byte MORETHAN = 14;
	public final byte LESSTHAN = 15;
	public final byte DIFFERENT = 16;
	public final byte MOREEQUAL = 17;
	public final byte LESSEQUAL = 18;
	public final byte COMMA = 19;
	public final byte PLUS = 20;
	public final byte MINUS = 21;
	public final byte MULT = 22;
	public final byte DIVIDE = 23;
	public final byte DOTCOMMA = 24;
	public final byte BEGIN = 25;
	public final byte END = 26;
	public final byte READ = 27;
	public final byte READLN = 28;
	public final byte WRITE = 29;
	public final byte WRITELN = 30;
	public final byte TRUE = 31;
	public final byte FALSE = 32;
	public final byte BOOLEAN = 33;

	public final byte ID = 34;
	public final byte CONST = 35;

	// Novos símbolos adicionados
	public final byte PROGRAM = 36;
	public final byte VAR = 38;
	public final byte CHAR = 39;
	public final byte TEXT = 40;
	public final byte STRING_TYPE = 41;
	public final byte CLRSCR = 42;
	public final byte ASSIGN = 43;
	public final byte REWRITE = 44;
	public final byte KBD = 45;
	public final byte WRITELN_PROC = 46;
	public final byte EOF_MARKER = 47;
	public final byte CLOSE = 48;
	public final byte RESET = 49;

	public TabelaSimbolos() {
		tabela.put("final", new Simbolo(FINAL, "final", "palavra reservada", ++end));
		tabela.put("int", new Simbolo(INT, "int", "palavra reservada", ++end));
		tabela.put("byte", new Simbolo(BYTE, "byte", "palavra reservada", ++end));
		tabela.put("string", new Simbolo(STRING, "string", "palavra reservada", ++end));
		tabela.put("while", new Simbolo(WHILE, "while", "palavra reservada", ++end));
		tabela.put("if", new Simbolo(IF, "if", "palavra reservada", ++end));
		tabela.put("else", new Simbolo(ELSE, "else", "palavra reservada", ++end));
		tabela.put("and", new Simbolo(AND, "and", "palavra reservada", ++end));
		tabela.put("or", new Simbolo(OR, "or", "palavra reservada", ++end));
		tabela.put("not", new Simbolo(NOT, "not", "palavra reservada", ++end));
		tabela.put("==", new Simbolo(EQUAL, "==", "operador relacional", ++end));
		tabela.put("=", new Simbolo(RECIEVE, "=", "operador de atribuição", ++end));
		tabela.put("(", new Simbolo(OPPAR, "(", "símbolo de abertura de parênteses", ++end));
		tabela.put(")", new Simbolo(CLPAR, ")", "símbolo de fechamento de parênteses", ++end));
		tabela.put(">", new Simbolo(MORETHAN, ">", "operador relacional", ++end));
		tabela.put("<", new Simbolo(LESSTHAN, "<", "operador relacional", ++end));
		tabela.put("!=", new Simbolo(DIFFERENT, "!=", "operador relacional", ++end));
		tabela.put(">=", new Simbolo(MOREEQUAL, ">=", "operador relacional", ++end));
		tabela.put("<=", new Simbolo(LESSEQUAL, "<=", "operador relacional", ++end));
		tabela.put(",", new Simbolo(COMMA, ",", "vírgula", ++end));
		tabela.put("+", new Simbolo(PLUS, "+", "operador aritmético", ++end));
		tabela.put("-", new Simbolo(MINUS, "-", "operador aritmético", ++end));
		tabela.put("*", new Simbolo(MULT, "*", "operador aritmético", ++end));
		tabela.put("/", new Simbolo(DIVIDE, "/", "operador aritmético", ++end));
		tabela.put(";", new Simbolo(DOTCOMMA, ";", "ponto e vírgula", ++end));
		tabela.put("begin", new Simbolo(BEGIN, "begin", "palavra reservada", ++end));
		tabela.put("end", new Simbolo(END, "end", "palavra reservada", ++end));
		tabela.put("readln", new Simbolo(READLN, "readln", "palavra reservada", ++end));
		tabela.put("write", new Simbolo(WRITE, "write", "palavra reservada", ++end));
		tabela.put("writeln", new Simbolo(WRITELN, "writeln", "palavra reservada", ++end));
		tabela.put("read", new Simbolo(READ, "read", "palavra reservada", ++end));
		tabela.put("boolean", new Simbolo(BOOLEAN, "boolean", "palavra reservada", ++end));

		// Novos símbolos adicionados
		tabela.put("program", new Simbolo(PROGRAM, "program", "palavra reservada", ++end));
		tabela.put("const", new Simbolo(CONST, "const", "palavra reservada", ++end));
		tabela.put("var", new Simbolo(VAR, "var", "palavra reservada", ++end));
		tabela.put("char", new Simbolo(CHAR, "char", "palavra reservada", ++end));
		tabela.put("text", new Simbolo(TEXT, "text", "palavra reservada", ++end));
		tabela.put("string", new Simbolo(STRING_TYPE, "string", "palavra reservada", ++end));
		tabela.put("clrscr", new Simbolo(CLRSCR, "clrscr", "palavra reservada", ++end));
		tabela.put("assign",
				new Simbolo(ASSIGN, "assign", "palavra reservada", ++end));
		tabela.put("rewrite",
				new Simbolo(REWRITE, "rewrite", "palavra reservada", ++end));
		tabela.put("kbd", new Simbolo(KBD, "kbd", "palavra reservada", ++end));
		tabela.put("^z",
				new Simbolo(EOF_MARKER, "^z", "palavra reservada", ++end));
		tabela.put("close", new Simbolo(CLOSE, "close", "palavra reservada", ++end));
		tabela.put("reset", new Simbolo(RESET, "reset", "palavra reservada", ++end));
		tabela.put(":", new Simbolo(RESET, ":", "dois pontos", ++end));
		tabela.put("#10", new Simbolo(RESET, "#10", "Nova Linha", ++end));
		tabela.put("#13", new Simbolo(RESET, "#13", "Retorno de Carro", ++end));
		tabela.put("#9", new Simbolo(RESET, "#9", "Tabulação", ++end));
		tabela.put("#39", new Simbolo(RESET, "#39", "Aspas Simples", ++end));
		tabela.put("#34", new Simbolo(RESET, "#34", "Aspas Duplas", ++end));
		tabela.put("#42", new Simbolo(RESET, "#42", "Asterisco", ++end));
		tabela.put("#43", new Simbolo(RESET, "#43", "Sinal de Mais", ++end));
		tabela.put("#45", new Simbolo(RESET, "#45", "Sinal de Menos", ++end));
		tabela.put("#46", new Simbolo(RESET, "#46", "Ponto (Decimal)", ++end));
		tabela.put("#59", new Simbolo(RESET, "#59", "Ponto e Vírgula", ++end));
		tabela.put("#44", new Simbolo(RESET, "#44", "Vírgula", ++end));
		tabela.put("#58", new Simbolo(RESET, "#58", "Dois Pontos", ++end));
		tabela.put("#63", new Simbolo(RESET, "#63", "Ponto de Interrogação", ++end));
		tabela.put("#124", new Simbolo(RESET, "#124", "Barra Vertical (Pipe)", ++end));
		tabela.put("#40", new Simbolo(RESET, "#40", "Parêntese Esquerdo", ++end));
		tabela.put("#41", new Simbolo(RESET, "#41", "Parêntese Direito", ++end));
		tabela.put("{", new Simbolo(RESET, "{", "Chave Esquerda", ++end));
		tabela.put("}", new Simbolo(RESET, "}", "Chave Direita", ++end));
		tabela.put("[", new Simbolo(RESET, "[", "Colchete Esquerdo", ++end));
		tabela.put("]", new Simbolo(RESET, "]", "Colchete Direito", ++end)); 
		tabela.put("repeat", new Simbolo(RESET, "repeat", "palavra reservada", ++end));
		tabela.put(".", new Simbolo(RESET, ".", "ponto final", ++end));
		tabela.put("eof", new Simbolo(RESET, "eof", "palavra reservada", ++end)); 
		tabela.put("type", new Simbolo(RESET, "type", "palavra reservada", ++end)); 
		tabela.put("integer", new Simbolo(RESET, "integer", "palavra reservada", ++end)); 
		tabela.put("real", new Simbolo(RESET, "real", "palavra reservada", ++end)); 
		tabela.put("file of", new Simbolo(RESET, "file of", "palavra reservada", ++end)); 
		tabela.put("array", new Simbolo(RESET, "array", "palavra reservada", ++end)); 
		tabela.put("of", new Simbolo(RESET, "of", "palavra reservada", ++end)); 
		tabela.put("seek", new Simbolo(RESET, "seek", "palavra reservada", ++end)); 
		tabela.put("(*", new Simbolo(RESET, "(*", "comentario", ++end)); 
		tabela.put("*)", new Simbolo(RESET, "*)", "comentario", ++end)); 
		tabela.put("//", new Simbolo(RESET, "//", "comentario", ++end)); 
		tabela.put(":=", new Simbolo(RESET, ":=", "simbolo", ++end)); 
		tabela.put("to", new Simbolo(RESET, "to", "palavra reservada", ++end)); 
		tabela.put("do", new Simbolo(RESET, "do", "palavra reservada", ++end));  
		tabela.put("procedure", new Simbolo(RESET, "procedure", "palavra reservada", ++end)); 
	}

	public int Pesquisar(String lexema) {
		lexema = lexema.toLowerCase();
		Simbolo aux = tabela.get(lexema);
		return aux.getEndereco();
	}

	public Simbolo BuscarSimbolo(String lexema) {
		lexema = lexema.toLowerCase();
		return tabela.get(lexema);
	}

	public Simbolo InserirID(String lexema) {
		lexema = lexema.toLowerCase();
		Simbolo simbolo = new Simbolo(ID, lexema, ++end);
		tabela.put(lexema, simbolo);
		return tabela.get(lexema);
	}

	public Simbolo inserirConst(String lexema, String tipo) {
		lexema = lexema.toLowerCase();
		Simbolo simbolo = new Simbolo(CONST, lexema, tipo, ++end);
		tabela.put(lexema, simbolo);
		return tabela.get(lexema);
	}
}
