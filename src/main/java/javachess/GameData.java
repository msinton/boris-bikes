package javachess;

import java.io.Serializable;

public class GameData implements Serializable {

    private String url;
    private String move;
    private String eval;
    private Integer evalSymbol;
    private Integer n;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public String getEval() {
        return eval;
    }

    public void setEval(String eval) {
        this.eval = eval;
    }

    public Integer getEvalSymbol() {
        return evalSymbol;
    }

    public void setEvalSymbol(Integer evalSymbol) {
        this.evalSymbol = evalSymbol;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

}
