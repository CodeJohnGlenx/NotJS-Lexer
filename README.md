# nJS Lexer

Lexer (Tokenizer) for NotJS programming language.


## Lex.java

Scans and tokenize each lexeme. Regex strings to match lexemes and its corresponding tokens are provided in. `Tokens.java` Successful output creates a text file called `LexOut.txt` that contains all the lexemes and its corresponding tokens.

## Tokens.java
Contains regex strings to match and tokenize lexemes.  

## LexOut.txt

The output file of the nJS lexer.

## Run nJS Lexer
To run the nJS lexer, simply call the `Lex` file and provide the `nJS` file.
> Note: Make sure that the extension of the input file is `.njs`

Sample command on Terminal
> **java Lex example.njs**
