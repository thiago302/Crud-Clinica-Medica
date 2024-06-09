package modelo;



public class Clinica {
    
    public Clinica(String nome, double prim, double seg, double ter, double qua, double sex) {
        this.nome = nome;
        this.prim = prim;
        this.seg = seg;
        this.ter = ter;
        this.qua = qua;
        this.sex = sex;
        this.media = this.calcularMedia();
        this.faturamento = this.calcularFaturamento();
    }
    
    public Clinica(int ra, String nome, double prim, double seg, double ter, double qua, double sex) {
        this.ra = ra;
        this.nome = nome;
        this.prim = prim;
        this.seg = seg;
        this.ter = ter;
        this.qua = qua;
        this.sex = sex;
        this.media = this.calcularMedia();
        this.faturamento = this.calcularFaturamento();
    }
    
    public Clinica() {}
    
    private int ra;
    private String nome;
    private double prim;
    private double seg;
    private double ter;
    private double qua;
    private double sex; 
    private double media;
    private double faturamento;
    private static final double valorDaConsulta = 100.0;
    
   
	

	public double getFaturamento() {
        return faturamento;
    }

    public static double getValorDaConsulta() {
        return valorDaConsulta;
    }

    public void setFaturamento(double faturamento) {
        this.faturamento = faturamento;
    }

    public double getSex() {
        return sex;
    }

    public void setSex(double sex) {
        this.sex = sex;
    }

    public double calcularMedia() {
        return (this.prim + this.seg + this.ter + this.qua + this.sex) / 5;
    }
    
    public double calcularFaturamento() {
        return this.calcularMedia() * valorDaConsulta;
    }
    
    public int getRa() {
        return ra;
    }
    
    public void setRa(int ra) {
        this.ra = ra;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public double getPrim() {
        return prim;
    }
    
    public void setPrim(double prim) {
        this.prim = prim;
    }
    
    public double getSeg() {
        return seg;
    }
    
    public void setSeg(double seg) {
        this.seg = seg;
    }
    
    public double getTer() {
        return ter;
    }
    
    public void setTer(double ter) {
        this.ter = ter;
    }
    
    public double getQua() {
        return qua;
    }
    
    public void setQua(double qua) {
        this.qua = qua;
    }
    
    public double getMedia() {
        return media;
    }
    
    public void setMedia(double media) {
        this.media = media;
    }
}

	



