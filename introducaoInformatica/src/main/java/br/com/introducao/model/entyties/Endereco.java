
package br.com.introducao.model.entyties;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="endereco")
public class Endereco implements Serializable{
   
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdEndereco", nullable=false)    
    private Integer idEndereco;
    @Column(name="Bairro", nullable=false) 
    private String bairro;
    @Column(name="NomeLogradouro", nullable=false) 
    private String nomeLogradouro;
    @Column(name="CEP", nullable=false) 
    private String cep;
    @Column(name="Numero", nullable=false) 
    private Integer numero;
    @Column(name="Complemento", nullable=false) 
    private String complemento;
    
    @OneToOne(optional=true, fetch= FetchType.LAZY)
    @ForeignKey(name="EnderecoPessoa")
    @JoinColumn(name="IdPessoa", referencedColumnName="IdPessoa")
    private Pessoa pessoa;
    
    @ManyToOne(optional=false, fetch= FetchType.LAZY)
    @ForeignKey(name="EnderecoCidade")
    @JoinColumn(name="IdCidade", referencedColumnName="IdTCidade")
    private Cidade cidade;
    
    @ManyToOne(optional=false, fetch= FetchType.LAZY)
    @ForeignKey(name="EndereEstado")
    @JoinColumn(name="IdEstado", referencedColumnName="IdEstado")
    private Estado estado;
    
    @ManyToOne(optional=false, fetch= FetchType.LAZY)
    @ForeignKey(name="EndereTipoLogradouro")
    @JoinColumn(name="IdTipoLogradouro", referencedColumnName="IdTipoLogradouro")
    private TipoLogradouro tipoLogradouro;
    
    @ManyToOne(optional=false, fetch= FetchType.LAZY)
    @ForeignKey(name="EndereTipoEndereco")
    @JoinColumn(name="IdTipoEndereco", referencedColumnName="IdTipoEndereco")
    private TipoEndereco tipoEndereco;

    /**
     * @return the idEndereco
     */
    public Integer getIdEndereco() {
        return idEndereco;
    }

    /**
     * @param idEndereco the idEndereco to set
     */
    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the nomeLogradouro
     */
    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    /**
     * @param nomeLogradouro the nomeLogradouro to set
     */
    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * @return the tipoLogradouro
     */
    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    /**
     * @param tipoLogradouro the tipoLogradouro to set
     */
    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    /**
     * @return the tipoEndereco
     */
    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    /**
     * @param tipoEndereco the tipoEndereco to set
     */
    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + (this.idEndereco != null ? this.idEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Endereco other = (Endereco) obj;
        if (this.idEndereco != other.idEndereco && (this.idEndereco == null || !this.idEndereco.equals(other.idEndereco))) {
            return false;
        }
        return true;
    }

    public Endereco() {
        this.cidade = new Cidade();
        this.estado = new Estado();
        this.tipoEndereco = new TipoEndereco();
        this.tipoLogradouro = new TipoLogradouro();
        this.pessoa = new Pessoa();
    }
    
    
}
