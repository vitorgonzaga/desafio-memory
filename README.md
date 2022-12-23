# Teste para Avaliação de Conhecimento

### Desenvolvedor de Software 
---

Para avaliar as habilidades do candidato à vaga de desenvolvedor de software será necessário que o mesmo implemente um mini projeto para **Gerenciamento de Medicamentos** com:

- Serviços que permitam incluir, remover e alterar as **REAÇÕES ADVERSAS** possíveis em medicamentos. Campos: id, descrição. 
- Serviços que permitam incluir, remover e alterar **MEDICAMENTOS**. Campos: 
    - número de registro da Anvisa (com máscara padrão 0.0000.0000.000-0);
    - nome do medicamento;
    - data de validade (com máscara padrão dd/mm/aaaa);
    - telefone do SAC (com máscara padrão (00)0000-0000);
    - preço em reais (com máscara padrão 0,00);
    - quantidade de comprimidos;
    - fabricante (atenção à relação com **FABRICANTE**, pois neste caso **um** medicamento deve ser cadastrado com **um** único fabricante. Não é texto livre, é selecionável. A lista de fabricantes deve ser previamente cadastrada no banco);
    - reações adversas (atenção à relação com **REAÇÕES ADVERSAS**, pois **um** medicamento pode ter **uma ou várias** reações adversas previstas na sua bula.)
- Um serviço que permita pesquisa de medicamento pelo nome ou pelo seu número de registro.


**O candidato deve criar um fork deste projeto e, ao final, realizar um pull request para o projeto principal.**


Como a principal característica do cargo a ser ocupado é atuar como dev em equipe de desenvolvimento de software, o projeto em questão deverá ser elaborado observando os seguintes critérios:

- Todas as consultas devem conter recursos de **paginação**.
- **Linguagem de programação Java utilizando Spring Boot.**
- Banco de dados **PostgreSQL**.
- Código **orientado a objetos**.
- **Código limpo** (Conforme boas práticas do livro Clean Code, do Robert Martin).
- **Commits pequenos** com descrição do que foi implementado.
- **Sistema escalonável**. Seu projeto deve ser codificado de forma a permitir alterações e adições de novas *features*.

> ATENÇÃO! 
Será considerado um diferencial o desenvolvimento de testes unitários para as principais funcionalidades. Prefira testes objetivos e assertivos aos complexos e extensos. Além disso, a configuração do Swagger para acesso e documentação de API também será considerada um diferencial. 


Caso o candidato não consiga entregar todos os requisitos, é importante descrever no README do projeto o que foi entregue, os critérios de priorização e se houveram impedimentos.

Além disso, o candidato deverá **gravar um vídeo explicativo COM ÁUDIO da solução implementada, duração máxima de 15 (QUINZE) minutos**, mostrando de forma INTERCALADA e CORRELACIONANDO:

- **código-fonte**: principais pontos.
- **banco de dados**: principais estruturas.
- **a aplicação em funcionamento**.  

Para tanto, sugerimos o Camtasia® ou o oCAM como softwares para gravação do vídeo com áudio, formato de exportação **.mp4** e com **áudio**. ATENÇÃO! Usar o formato de compressão sugerido ou outro que gere um arquivo em um tamanho e qualidade de vídeo e áudio razoáveis para download, visualização e entendimento da explicação. 	

Ao finalizar os trabalhos, o BANCO DE DADOS e o VÍDEO deverão ser compactados e postados no [WeTransfer](https://www.wetransfer.com/) enviando o link para download para a [Memory](rh@memory.com.br). Caso o projeto seja aceito, o candidato será convidado a apresentá-lo nas dependências da empresa.


>IMPORTANTE: 
O vídeo com áudio é parte imprescindível da entrega. Caso o candidato envie somente o código-fonte e banco de dados, a prova nem será avaliada. 


> DICA: 
Use esse texto como um checklist! Principalmente os itens marcados com  uma vez que a correção e sua pontuação serão baseadas exatamente na execução dos itens obrigatórios. Atenção também com o **tempo do vídeo, data de entrega** e aos **detalhes do enunciado** assim como um desenvolvedor tem que ter com as entregas de um projeto e detalhes de especificação. 



**Sucesso no teste!** :smile:
