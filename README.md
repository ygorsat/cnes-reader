# cnes-reader
Leitor de CNES a partir de URL configurável com H2 Memory Database

- Backend
-- Desenvolvido com Spring Framework (Maven, Spring Boot, JPA, Validation API, Sprint Data - Criteria API + CRUD Repository, Http Client, Model Mapper)
--- Executar "Run As" ou "Debug As" a classe CnesReaderApplication.java
--- A aplicação faz o download do arquivo .CSV com as informações do CNES a partir de URL configurável, as insere em um H2 Memory Database utilizando JPA (persistência em lote).
---- O download é feito via Listener no "On Ready" da aplicação. Sendo assim, não é necessário executar nenhuma ação além de inicializar a aplicação para o download e a persistência em banco ocorrerem

--- As APIs estão expostas para visualização no link: http://localhost:8080/cnesreader/swagger-ui.html e são:
---- /cnes (GET) - Consulta de CNES por filtros: CNES (cnes), Nome Fantasia (nomeFantasia), Tipo Gestão (tipo), Descrição de Tipo de Unidade (tipoUnidade), Unidade Federativa (uf). Retorno paginado.
---- /cnes (POST) - Cadastro de um novo CNES com todos os campos descritos no arquivo CSV para inserção de valor 
---- /cnes/{id} (GET) - Recuperar de forma detalhada todas as informações de um CNES por ID
---- /cnes/{id} (PUT) - Alterar todas ou parcilamente as informações de um CNES por ID
---- /cnes/all (GET) - Recupera todos os CNES sem filtros;

*O backend está totalmente documentado.

- Frontend
-- Desenvolvido com Angular IO (Versão 7), Typescript, Bootstrap 4 e NPM
-- Realizar "npm install" após finalização executar "ng serve" ou "npm start". A aplicação está disponível em http://localhost:4200

*A aplicação do frontend tem a URL de ambiente para integração com o backend configurável
*É necessário possui o nodeJs (NPM) instalado na máquina de execução.

-- A aplicação possui 3 telas simples.

-- Home
--- Tela de landing page apenas com informação de redirecionamento para a aplicação de consulta do CNES;
-- Pesquisar
--- Tela de pesquisa com os filtros CNES, Nome Fantasia, Tipo de Gestão, Unidade Federativa, Descrição Tipo de Unidade;
--- Retorno é exibido em GRID com paginação contendo informações ID, Tipo de Gestão, CNES, Nome Fantasia, Municipio e Unidade Federativa e "olho para visualizar". 20 itens por página, ordenados pelo Nome Fantasia. Total de registros também é exibido.
--- Botões de Pesquisar e Limpar. Tratativa de erro do sistema ao verificar que não há itens retornados para os filtros de pesquisa informados.
-- Visualizar
--- Ao clicar no "olho para visualizar", o usuário é redirecionado para uma tela, onde terá a exibição completa de todos os dados do CNES. Botão de voltar redireciona para a tela anterior.
---- Os dados exibidos são: CNES, Nome Fantasia, Código do IBGE, Descrição do Tipo de Unidade, Tipo de Gestão, Endereço, Unidade Federativa, Municipio e Telefone de Contato. 
