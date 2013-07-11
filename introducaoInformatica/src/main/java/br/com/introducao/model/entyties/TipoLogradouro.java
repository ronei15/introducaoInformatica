package br.com.introducao.model.entyties;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "tipo_logradouro")
public class TipoLogradouro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "IdTipoLogradouro", nullable = false)
    private Integer idtTipoLogradouro;
    @Column(name = "DescricaoTipoLogradouro", nullable = false, length = 40)
    private String descricaoTipoLogradouro;
    @OneToMany(mappedBy = "tipo_logradouro", fetch = FetchType.LAZY)
    @ForeignKey(name = "LogradouroEndereco")
    private List<Endereco> enderecos;

    /**
     * @return the idtTipoLogradouro
     */
    public Integer getIdtTipoLogradouro() {
        return idtTipoLogradouro;
    }

    /**
     * @param idtTipoLogradouro the idtTipoLogradouro to set
     */
    public void setIdtTipoLogradouro(Integer idtTipoLogradouro) {
        this.idtTipoLogradouro = idtTipoLogradouro;
    }

    /**
     * @return the descricaoTipoLogradouro
     */
    public String getDescricaoTipoLogradouro() {
        return descricaoTipoLogradouro;
    }

    /**
     * @param descricaoTipoLogradouro the descricaoTipoLogradouro to set
     */
    public void setDescricaoTipoLogradouro(String descricaoTipoLogradouro) {
        this.descricaoTipoLogradouro = descricaoTipoLogradouro;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.idtTipoLogradouro != null ? this.idtTipoLogradouro.hashCode() : 0);
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
        final TipoLogradouro other = (TipoLogradouro) obj;
        if (this.idtTipoLogradouro != other.idtTipoLogradouro && (this.idtTipoLogradouro == null || !this.idtTipoLogradouro.equals(other.idtTipoLogradouro))) {
            return false;
        }
        return true;
    }
}
