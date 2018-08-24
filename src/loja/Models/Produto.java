
package loja.Models;

public class Produto {
    
    private int codigoProduto;
    private String descricaoProduto;
    private double precoProduto;

    
    public Produto(int codigo, String descricao, double preco){
        this.setCodigoProduto(codigo);
        this.setDescricaoProduto(descricao);
        this.setPrecoProduto(preco);
    }
    
    public Produto(){
        
    }
    
    /**
     * @return the codigoProduto
     */
    public int getCodigoProduto() {
        return codigoProduto;
    }

    /**
     * @param codigoProduto the codigoProduto to set
     */
    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    /**
     * @return the descricaoProduto
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    /**
     * @param descricaoProduto the descricaoProduto to set
     */
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    /**
     * @return the precoProduto
     */
    public double getPrecoProduto() {
        return precoProduto;
    }

    /**
     * @param precoProduto the precoProduto to set
     */
    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }
    
}
