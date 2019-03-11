package br.com.professordanilo.site.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String conteudo;
	@Column(name="data_criacao")
	private Date dataCriacao;
	@Column(name="data_ultima_atualizacao")
	private Date dataUltimaAtauzlizacao;
	@Column(name="data_publicacao")
	private Date dataPubliacao;
	@ManyToOne
	private Usuario autor;
	private String imagemDestaque;
	private String link;
	@ManyToOne
	@JoinColumn(name="post_id")
	private Post postSuperior;
	@OneToMany(mappedBy="postSuperior")
	private List<Post> postsFilhos;
	@Column(name="visivel_menu")
	private Boolean visivelMenu;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getDataUltimaAtauzlizacao() {
		return dataUltimaAtauzlizacao;
	}
	public void setDataUltimaAtauzlizacao(Date dataUltimaAtauzlizacao) {
		this.dataUltimaAtauzlizacao = dataUltimaAtauzlizacao;
	}
	public Date getDataPubliacao() {
		return dataPubliacao;
	}
	public void setDataPubliacao(Date dataPubliacao) {
		this.dataPubliacao = dataPubliacao;
	}
	public Usuario getAutor() {
		return autor;
	}
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	public String getImagemDestaque() {
		return imagemDestaque;
	}
	public void setImagemDestaque(String imagemDestaque) {
		this.imagemDestaque = imagemDestaque;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Post getPostSuperior() {
		return postSuperior;
	}
	public void setPostSuperior(Post postSuperior) {
		this.postSuperior = postSuperior;
	}
	public List<Post> getPostsFilhos() {
		return postsFilhos;
	}
	public void setPostsFilhos(List<Post> postsFilhos) {
		this.postsFilhos = postsFilhos;
	}
	public Boolean getVisivelMenu() {
		return visivelMenu;
	}
	public void setVisivelMenu(Boolean visivelMenu) {
		this.visivelMenu = visivelMenu;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
