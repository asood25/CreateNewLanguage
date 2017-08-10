package com.ashish.hackerrank;

import java.util.*;

public class CreateNewLanguage {
	
    public static void main(String args[] ) throws Exception {
        NewLanguage nl = new NewLanguage();
        nl.userInput();
    }
}

class NewLanguage {
    
    protected void userInput() {
        
        Scanner scan = new Scanner(System.in);
        
        LinkedHashSet<String> lettersInputSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> lettersPositionSet = new LinkedHashSet<>();
        
        lettersInput( scan, lettersInputSet, 1, 26 );
        lettertsPositionInput( scan, lettersPositionSet, 1, 26 );
        printNewLanguage( lettersInputSet, lettersPositionSet );
        
        scan.close();
    }
    
    private void lettersInput( Scanner scan, LinkedHashSet<String> lettersInputSet, int startOffset, int endOffset ) {
        
        try {
            
            System.out.println( "Please enter the 26 letters in lower case" );
            
            for( int i = startOffset; i <= endOffset; i++ ) {
                
                System.out.print("Letter " + i + " : ");
                String input = scan.next();
                
                if( !( input.matches( "^[a-z]{1}$" ) ) ) {
                    System.out.println( "Wrong Input. Only lower case letters a-z allowed" );
                    i--;
                    continue;
                }
                
                if( lettersInputSet.contains( input ) ) {
                    System.out.println( "Duplicate letter entry not allowed" );
                    i--;
                    continue;
                }
                
                lettersInputSet.add( input );
            }
            
        } catch( Exception e ) {
            e.getMessage();
        }
    }
    
    private void lettertsPositionInput( Scanner scan, LinkedHashSet<Integer> lettersPositionSet, int startOffset, int endOffset ) {
    
        try {
            
            System.out.println( "Please enter the 26 letters position" );
            
            for( int i = startOffset; i <= endOffset; i++ ) {
                
                System.out.print("Letter Position : ");
                String input = scan.next();
                
                if( !( input.matches( "^([1-9]|[1-9][0-9]|26)$" ) ) || Integer.parseInt(input) > 26 ) {
                    System.out.println( "Wrong Input. Only integer values upto 2 digits max value 26 allowed" );
                    i--;
                    continue;
                }
                
                int position = Integer.parseInt( input );
                
                if( lettersPositionSet.contains( position ) ) {
                    System.out.println( "Duplicate letter entry not allowed" );
                    i--;
                    continue;
                }
                
                lettersPositionSet.add( position );
            }
            
        } catch( Exception e ) {
            e.getMessage();
        }
    }
    
    private void printNewLanguage( LinkedHashSet<String> lettersInputSet, LinkedHashSet<Integer> lettersPositionSet ) {
        
        String[] newLanguage = new String[ 26 ];
        LinkedList<String> l1 = new LinkedList<>( lettersInputSet );
        LinkedList<Integer> l2 = new LinkedList<>( lettersPositionSet );
        
        for( int i = 0; i < newLanguage.length; i++ ) {
            
            newLanguage[ ( l2.get( i ) - 1 ) ] = l1.get( i );
        }
        
        for( int j = 0; j < newLanguage.length; j++ ) {
       
            System.out.print( newLanguage[j] + " " );
        }  
    }
}
