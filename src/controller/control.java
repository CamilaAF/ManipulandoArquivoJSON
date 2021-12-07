package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class control {
	//Criei a variavel com o diretorio do arquivo
	private static final String ARQ_MOEDA = "C:\\Windows\\Temp\\exchange.json";
	
	//Metodo que irá buscar a entrada
	public void Buscar(String unit)throws IOException{
				File arquivo = new File(ARQ_MOEDA);
				
					if(arquivo.exists()&&arquivo.isFile()) {
						
						FileInputStream fis = new FileInputStream(arquivo);
						InputStreamReader isr = new InputStreamReader(fis);
						BufferedReader br = new BufferedReader(isr);
						String linha = br.readLine();
						
						while (linha != null) {
							//durante o while ele vai pegar todas as linhas e separar apartir do } e botar no vetLinha
							String[] vetLinha = linha.split("}");
							//agora eu faço um for que vai percorrer todo o vetor e procurar se contem a unit em algum desses lugares no vetor
							for(int a=0; a<vetLinha.length; a++) {
								if(vetLinha[a].contains(unit)) {
									
									//System.out.println(vetLinha[a]);
									//aqui o vetor resultado vai receber as linhas que estão no vetLinha separando apartir da virgula
									String[] resultado = vetLinha[a].split(",");
									//for que vai pegar e mostrar o resultado dessa separação
									//utilizei o fore como tratamento de erro no caso se chegasse até 4 o indice dava erro então retirei um antes dele entrar no for pra poder mostrar td
									int fore = resultado.length -1;
									for(int b=0;b <=fore;b++) {
											//substitui o { por = só pra ficar mais bonito de ver
											resultado[1] = resultado[1].replace(":{","=");
											//retirei o rates só pra que fiquei parecido com os outros
											if(resultado[0].contains("rates")) {
												resultado[0] = resultado[0].replace("{\"rates\":{", "");
												resultado[0] = resultado[0].replace(":{", "=");
											}
											System.out.println(resultado[b]);
											System.out.println("______________________");
									}
								}
							}
								linha = br.readLine();
								}
							br.close();
							isr.close();
							fis.close();
						}
						
					}				
				
		}	
