import { Component, OnInit } from '@angular/core';
import { CategoriaService } from '../categoria.service';

import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-painel-gerenciar-categoria',
  templateUrl: './painel-gerenciar-categoria.component.html',
  styleUrls: ['./painel-gerenciar-categoria.component.css']
})
export class PainelGerenciarCategoriaComponent implements OnInit {

  categoria = {};
  categorias = [];

  constructor(private categoriaService: CategoriaService,
    private messageService: MessageService) { }

  ngOnInit() {
    this.consultar();
  }

  consultar(){
    this.categoriaService.listar().subscribe(resposta => this.categorias = <any> resposta);
  }

  editar(categoria: any){
    this.categoria = categoria;
  }

  adicionar(){
    this.categoriaService.adicionar(this.categoria).subscribe(() => {
      this.categoria = {};
      this.consultar();
      this.messageService.add({
        severity: 'success',
        summary: 'Salva com sucesso.'
      });
    },
    resposta => {
      let message = 'Erro ao adicionar.';

      if(resposta.error.message){
        message = resposta.error.message;
      }

      this.messageService.add({
        severity: 'error',
        summary: message
      });
    }
  );
  }
}
