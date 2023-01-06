String program = input();

# check if program's value is "Lexer"
if (program == "Lexer") {
    output("It's a Lexer!");
} else {
    output("It's not a Lexer!");
}

bool _isLegalAge;
_isLegalAge = true;
switch (_isLegalAge) {
    case true:
        output("adult");
        break;

    case false:
        output("minor");
        break;

    default:
       output("can't recognize");
}