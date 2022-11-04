public class Calculator {
    private char operator;
    private int operand1, operand2;
    private String expression;


    public Calculator() {
    }

    public char getOperator() {
        return operator;
    }

    public int getOperand1() {
        return operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setOperands() {
        String split[] = expression.split(" ");
        operand1 = Integer.parseInt(split[0]);
        operand2 = Integer.parseInt(split[split.length - 1]);

    }
    public boolean verify(){            // verifying the expressions
        boolean checkingValid = false;
        int numberOfSpace=0;
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i) == '*'){
                operator = '*';
                if(expression.charAt(i-1) == ' ' & expression.charAt(i+1) == ' '){

                    setOperands();
                   checkingValid = true;
                }


            }
            else if(expression.charAt(i) == '/'){
                operator = '/';
                if(expression.charAt(i-1) == ' ' & expression.charAt(i+1) == ' '){
                    setOperands();
                    if(operand2 == 0){
                        checkingValid = false;
                    }
                    else {
                        checkingValid = true;
                    }
                }
            }
            else if(expression.charAt(i) == '+'){
                operator = '+';
                if(expression.charAt(i-1) == ' ' & expression.charAt(i+1) == ' '){
                    setOperands();
                    checkingValid = true;
                }
            }
            else if(expression.charAt(i) == '-'){
                operator = '-';
                if(expression.charAt(i-1) == ' ' & expression.charAt(i+1) == ' '){
                    setOperands();
                  checkingValid = true;
                }
            }
            else if(expression.charAt(i) == ' '){
                numberOfSpace++;
            }
        }
        if(expression.charAt(0) == ' ' || numberOfSpace > 2){
            checkingValid = false;
        }

        return checkingValid;


    }

    public int evaluate(){
    int result=0;
     //Evaluating Expression
    char c=this.operator;
    switch(c){

        case '-' :
            result=this.operand1-this.operand2;
            break;
        case '/' :
            result=this.operand1/this.operand2;
            break;
        case '+' :
            result=this.operand1+this.operand2;
            break;
        case '*' :
            result=this.operand1*this.operand2;
            break;

    }


return result;
}



}
