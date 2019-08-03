import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Hangman {
	int main(){
		Scanner kboard = new Scanner(System.in);
		char[][] words = {
				{'a', 'p', 'p', 'l', 'e'},
				{'b', 'o', 'y'},
				{'c', 'a', 'r'},
				{'d', 'o', 'g'},
				{'e', 'l', 'e', 'p', 'h', 'a', 'n', 't'},
				{'f', 'a', 'r', 'm'},
				{'g', 'u', 'a', 'c', 'a', 'm', 'o', 'l', 'e'},
				{'h', 'a', 't'},
				{'i', 'g', 'l', 'o', 'o'},
				{'j', 'e', 'l', 'l', 'y'},
				{'k', 'a', 'n', 'g', 'a', 'r', 'o', 'o'},
				{'l', 'o', 'l', 'l', 'i', 'p','o', 'p'},
				{'m', 'o', 'v', 'i', 'e'},
				{'n', 'u', 'm', 'b', 'e', 'r'},
				{'o', 'c', 't', 'a', 'g','o', 'n'},
				{'p','o', 'p', 'c', 'o', 'r', 'n'},
				{'q', 'u', 'i', 't', 'e'},
				{'r', 'e', 'd'},
				{'s','i', 'l', 'e', 'n', 'c', 'e'},
				{'t', 'e', 'a', 'm', 'm', 'a', 't', 'e'},
				{'u', 'n', 'i', 'q', 'u', 'e'},
				{'v','i', 'c', 't', 'o', 'r', 'y'},
				{'w','i', 'z', 'a', 'r', 'd'},
				{'x', 'y', 'l', 'o', 'p', 'h', 'o', 'n', 'e'},
				{'y', 'e', 'l', 'l', 'o', 'w'},
				{'z', 'e', 'b', 'r', 'a'}
			};
		
		int pick = (int)Math.random() * 25;
		System.out.println("The word has " + words[pick].length + " letters.");
		char[] word = new char[words[pick].length];
		int strikes = 0;
		boolean won = false;
		
		while(strikes < 7 && !won){
			System.out.println("Guess a lowercase letter: ");
			char l = 0;
			int underscores = 0;
			boolean find = (boolean) kboard.hasNext();
			while (find){
				try {
					l = (char) System.in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			int times = 0;
			for( int x = 0; x < words[pick].length; x++ ){
				if (l == words[pick][x]){
					word[x] = l;
					times++;
				}
			}
			if (times == 0){
				strikes++;
				System.out.println("Incorrect, guess again");
			}
			else{
				for( int x = 0; x < word.length; x++ ){
					if(word[x]=='\u0000'){
						System.out.print("_");
						underscores++;
					}else{
						System.out.print(words[pick][x]);
					}
				
				}
				if (underscores == 0){
					won = true;
				}
				underscores = 0;
			}
		}
		
		if( won ){
			System.out.println("Congratulations! You won!");
		}else{
			System.out.println("You lose:( Better luck next time!");
		}
		return 0;
	}
}
