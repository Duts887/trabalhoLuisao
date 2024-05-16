import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ManipuladorArquivo {

    // Lista para armazenar os tokens lidos do arquivo
    public List<Token> token = new ArrayList<Token>();
    // Tabela de símbolos utilizada para buscar informações sobre os tokens
    public TabelaSimbolos simbolos = new TabelaSimbolos();

    // Método que retorna o índice do primeiro token de comentário encontrado na linha
    public static int indicePrimeiroTokenComentario(String linha) {
        int posChave = linha.indexOf("{");
        int posParenteses = linha.indexOf("(*");
        int posComentario = linha.indexOf("//");

        // Inicializando a menor posição com um valor alto
        int menorPosicao = Integer.MAX_VALUE;

        // Verifica a posição do token de comentário '{' e atualiza menorPosicao se encontrado
        if (posChave != -1 && posChave < menorPosicao) {
            menorPosicao = posChave;
        }

        // Verifica a posição do token de comentário '(*' e atualiza menorPosicao se encontrado
        if (posParenteses != -1 && posParenteses < menorPosicao) {
            menorPosicao = posParenteses;
        }

        // Verifica a posição do token de comentário '//' e atualiza menorPosicao se encontrado
        if (posComentario != -1 && posComentario < menorPosicao) {
            menorPosicao = posComentario;
        }

        // Se nenhum token foi encontrado, retorna -1, caso contrário retorna a menor posição
        return (menorPosicao == Integer.MAX_VALUE) ? -1 : menorPosicao;
    }

    // Método que retorna o token de comentário que aparece primeiro na linha
    public static String verificaQualTokenComentarioVemPrimeiro(String linha) {
        int posChave = linha.indexOf("{");
        int posParenteses = linha.indexOf("(*");
        int posComentario = linha.indexOf("//");

        // Caso nenhum dos três tokens esteja presente na linha
        if (posChave == -1 && posParenteses == -1 && posComentario == -1) {
            return null;
        }

        // Utilizando o método para obter o índice do primeiro token de comentário
        int menorPosicao = indicePrimeiroTokenComentario(linha);

        // Retorna o token de comentário correspondente à menor posição encontrada
        if (menorPosicao == posChave) {
            return "{";
        } else if (menorPosicao == posParenteses) {
            return "(*";
        } else if (menorPosicao == posComentario) {
            return "//";
        }

        return null; // Este retorno é apenas uma segurança adicional
    }

    // Método para adicionar um token à lista de tokens, se não for vazio
    public void AdicionarToken(String lexema, String tipo) {
        if (!lexema.trim().isEmpty()) {
            token.add(new Token(lexema, tipo));
        }
    }

    // Método para ler o conteúdo de um arquivo e analisar os tokens
    public void Leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String codigodalinha = "";
        int contadorLinhas = 0;
        int indiceTokenInicioComentario = 0;
        int indiceTokenFinalComentario = 0;
        int primeiraLinhaComentada = 0;
        int ultimalinhaComentada = 0;
        Boolean temInicioTokenComentario = false;
        Boolean temFinalTokenComentario = false;
        String tokenComentario = "";

        while (true) {
            if (codigodalinha != null) {
                String tokenString = "";
                contadorLinhas = contadorLinhas + 1;

                // Se o comentário é do tipo '//' e a linha atual é maior que a primeira comentada
                if (tokenComentario == "//" && contadorLinhas > primeiraLinhaComentada) {
                    temInicioTokenComentario = false;
                }

                // Verifica se há um token de comentário na linha e se não está dentro de um comentário
                if (verificaQualTokenComentarioVemPrimeiro(codigodalinha) != null
                        && temInicioTokenComentario == false) {
                    tokenComentario = verificaQualTokenComentarioVemPrimeiro(codigodalinha);
                    temInicioTokenComentario = true;
                    primeiraLinhaComentada = contadorLinhas;
                    indiceTokenInicioComentario = indicePrimeiroTokenComentario(codigodalinha);
                }

                // Verifica se há um token de final de comentário na linha
            	if (codigodalinha.contains("}") && tokenComentario == "{"
						|| codigodalinha.contains("*)") && tokenComentario == "(*") {
					ultimalinhaComentada = contadorLinhas;
					indiceTokenFinalComentario = tokenComentario == "{" ? codigodalinha.indexOf("}")
							: codigodalinha.indexOf("*)");
					temFinalTokenComentario = true;

				}

                // Verifica se a linha não contém tokens de início ou final de comentário
                if (!codigodalinha.contains("{") && !codigodalinha.contains("}")
                        || !codigodalinha.contains("(*") && !codigodalinha.contains("*)")) {
                    // Se o token de final de comentário foi encontrado e a linha atual é maior que a última comentada
                    if (temFinalTokenComentario && contadorLinhas > ultimalinhaComentada) {
                        temInicioTokenComentario = false;
                        temFinalTokenComentario = false;
                    }
                }

                int indiceStringSimbolo = 0;
                if (codigodalinha.length() != 0) {
                    tokenString += codigodalinha.charAt(0);
                    for (int i = 1; codigodalinha.length() > i; i++) {
                        if (tokenString.trim().isEmpty()) {
                            tokenString = codigodalinha.charAt(i) + "";
                            continue;
                        }

                        // Se está dentro de um comentário, ignora os caracteres entre os delimitadores do comentário
                        if (temInicioTokenComentario) {
                            if (contadorLinhas == primeiraLinhaComentada && contadorLinhas == ultimalinhaComentada) {
                                if (i > indiceTokenInicioComentario && i <= indiceTokenFinalComentario) {
                                    tokenString = codigodalinha.charAt(i) + "";
                                    continue;
                                }
                            }

                            if (contadorLinhas == primeiraLinhaComentada) {
                                if (i > indiceTokenInicioComentario) {
                                    tokenString = codigodalinha.charAt(i) + "";
                                    continue;
                                }
                            }

                            if (contadorLinhas > primeiraLinhaComentada && contadorLinhas == ultimalinhaComentada) {

                                if (i < indiceTokenFinalComentario) {
                                    tokenString = codigodalinha.charAt(i) + "";
                                    continue;
                                }
                            }

                            if (contadorLinhas > primeiraLinhaComentada) {
                                tokenString = codigodalinha.charAt(i) + "";
                                continue;
                            }

                        }

                        // Se o token contém um apóstrofo, trata-o como um literal
                        if (tokenString.contains("'")) {
                            int primeiraIncidencia = codigodalinha.indexOf("'");
                            int segundaIncidencia = codigodalinha.indexOf("'", primeiraIncidencia + 1);

                            if (segundaIncidencia != -1 && segundaIncidencia != i) {
                                tokenString += codigodalinha.charAt(i) + "";
                                continue;
                            } else if (segundaIncidencia != -1 && segundaIncidencia == i) {
                                token.add(new Token(tokenString + codigodalinha.charAt(i), "Literal"));
                                tokenString = "";
                                continue;

                            }

                        }

                        // Busca símbolos na tabela de símbolos
                        var simboloAtual = simbolos.BuscarSimbolo(tokenString);
                        var simboloProximo = simbolos.BuscarSimbolo(tokenString + codigodalinha.charAt(i));

                        // Se a linha é 37, imprime o token e o símbolo atual (para depuração)
                        if (contadorLinhas == 37) {
                            System.out.println(tokenString + " token");
                            System.out.println(simboloAtual + " atual");
                        }

                        // Se encontrou um símbolo, tenta encontrar o símbolo mais longo possível
                        if (simboloAtual != null) {
                            indiceStringSimbolo = i;
                            String tokenAux = tokenString;
                            for (int j = i; j < codigodalinha.length(); j++) {
                                tokenAux += codigodalinha.charAt(j) + "";

                                if (i == 9) {
                                }

                                var simboloTokenAux = simbolos.BuscarSimbolo(tokenAux);
                                if (simboloTokenAux != null) {
                                    indiceStringSimbolo = j;
                                }
                            }
                        }

                        // Verifica se é o final da linha
                        Boolean finalDaLinha = i == codigodalinha.length() - 1;
                        if (finalDaLinha) {
                            if (simboloAtual != null) {
                                AdicionarToken(tokenString, RetornaTipo(tokenString));
                                AdicionarToken(codigodalinha.charAt(i) + "", RetornaTipo(codigodalinha.charAt(i) + ""));
                                tokenString = "";
                            } else if (simboloProximo != null) {
                                AdicionarToken(tokenString + codigodalinha.charAt(i), RetornaTipo(tokenString + codigodalinha.charAt(i)));
                                tokenString = "";
                            } else {
                                if (NaoTemCaracterEspecial(tokenString) && NaoTemCaracterEspecial(codigodalinha.charAt(i) + "")) {
                                    AdicionarToken(tokenString + codigodalinha.charAt(i), RetornaTipo(tokenString + codigodalinha.charAt(i)));
                                    tokenString = "";
                                } else {
                                    AdicionarToken(tokenString, RetornaTipo(tokenString));
                                    AdicionarToken(codigodalinha.charAt(i) + "", RetornaTipo(codigodalinha.charAt(i) + ""));
                                    tokenString = "";
                                }
                            }
                        } else {
                            if (simboloAtual != null && simboloProximo == null && indiceStringSimbolo == i) {
                                AdicionarToken(tokenString, RetornaTipo(tokenString));
                                tokenString = "";
                            } else if (NaoTemCaracterEspecial(tokenString) && !NaoTemCaracterEspecial(codigodalinha.charAt(i) + "")) {
                                AdicionarToken(tokenString, RetornaTipo(tokenString));
                                tokenString = "";
                            }
                        }
                        tokenString += codigodalinha.charAt(i);
                    }
                }
            } else
                break;
            codigodalinha = buffRead.readLine();
        }
        buffRead.close();

    }

    // Método que verifica se o input não contém caracteres especiais
    public static boolean NaoTemCaracterEspecial(String input) {
        if (input.trim().isEmpty()) {
            String regex = "^[a-zA-Z0-9_ ]*$";
            System.out.println(Pattern.matches(regex, input) + " patern");

        }
        // Expressão regular para verificar se não há caracteres especiais
        String regex = "^[a-zA-Z0-9_]*$";
        return Pattern.matches(regex, input);
    }

    // Método para escrever os tokens em um arquivo
    public void Escritor(String path) throws IOException {
        try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true))) {
            // Cabeçalhos da tabela
            String header = String.format("%-40s %-40s%n", "Lexema", "Tipo");
            String separator = String.format("%-40s %-40s%n", "--------------------", "--------------------");

            // Escreve os cabeçalhos e o separador
            buffWrite.write(header);
            buffWrite.write(separator);

            // Escreve os dados dos tokens
            for (Token t : token) {
                String line = String.format("%-40s %-40s%n", t.getLexema(), t.getTipo());
                buffWrite.write(line);
            }
        }

    }

    // Método que retorna o tipo do token
    public String RetornaTipo(String lexema) {
        var simbolo = simbolos.BuscarSimbolo(lexema);
        if (simbolo != null) {
            return simbolo.getTipo();
        } else if (lexema.matches("[0-9]+")) {
            return "Number";
        } else {
            return "Identificador";
        }
    }

}
