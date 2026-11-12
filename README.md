🛒 Sistema de Gerenciamento de Supermercado

Sistema desktop desenvolvido em Java para simular e gerenciar as operações cotidianas de um supermercado, incluindo controle de estoque, precificação promocional, frente de caixa com emissão de cupom fiscal, relatórios gerenciais e persistência de dados.

Projeto desenvolvido como Trabalho Final da disciplina de Programação Orientada a Objetos (POO) do curso de Sistemas de Informação da Universidade Federal do Ceará (UFC) – Campus Quixadá.

🏗️ Arquitetura do Projeto (MVC)

O sistema foi estruturado seguindo o padrão arquitetural MVC (Model-View-Controller) aliado a uma camada dedicada de Persistência, garantindo baixo acoplamento, organização e facilidade de manutenção:

Model (Modelo): Representa as entidades e regras intrínsecas do domínio (Pessoa, Cliente, Funcionario, Produto, ProdutoNormal, ProdutoPromocional, Venda e a interface Autenticavel).

View (Visão): Interface gráfica construída integralmente com Java Swing (TelaLogin, TelaFuncionario, TelaCliente, TelaProduto, TelaVenda, TelaRelatorio, TelaHistoricoVendas, entre outras). Responsável exclusivamente pela interação com o usuário, delegando todo o processamento ao Controller.

Controller (Controlador): Centralizado na classe SupermercadoController, atua como o núcleo lógico da aplicação. Gerencia as coleções em memória (ArrayList), valida regras de negócio, realiza autenticações, calcula métricas financeiras e coordena a comunicação entre a interface gráfica e os arquivos.

Persistência em Arquivos: Classes ArqCliente, ArqFuncionario, ArqProduto e ArqVendas, responsáveis por salvar e recuperar o estado dos objetos em disco utilizando Serialização Binária (.txt). Inclui a classe customizada AppendableObjectOutputStream para permitir a gravação incremental de novos registros sem corromper o cabeçalho (stream header) dos arquivos.

🔐 Níveis de Acesso e Funcionalidades

O sistema conta com autenticação diferenciada por perfil de usuário (CPF e Senha) e fluxo de recuperação de senha:

👔 Controle Total para Funcionários (Administrativo)

Ao autenticar-se como Funcionário, o usuário tem controle irrestrito sobre a operação do supermercado:

Gestão de Produtos (CRUD): Cadastro, listagem em tabela, edição e exclusão de itens, com suporte a Produtos Normais e Produtos Promocionais (aplicação dinâmica de percentual de desconto).

Gestão de Clientes e Funcionários: Cadastro e visualização de usuários com contabilização automática via atributos de classe (static).

Frente de Caixa (Vendas): Realização de vendas com baixa automática no estoque e geração de Cupom Fiscal detalhado.

Histórico de Vendas: Consulta de todas as transações efetuadas e acompanhamento do faturamento acumulado.

Relatório Gerencial: Painel consolidado exibindo total de cadastros, número de vendas, faturamento total e identificação automática do produto mais vendido.

Gestão de Perfil: Atualização de dados cadastrais ou exclusão da própria conta.

🛍️ Acesso para Clientes

Ao autenticar-se como Cliente (com opção de auto-cadastro na tela inicial), o usuário possui acesso restrito às suas operações:

Realização de Compras: Seleção de produtos disponíveis em estoque, validação de quantidade e visualização do cupom fiscal da compra.

Meu Perfil: Edição de nome, CPF e senha, ou encerramento da conta.

🧠 Conceitos de POO Aplicados

Abstração e Herança: Classes abstratas Pessoa (estendida por Cliente e Funcionario) e Produto (estendida por ProdutoNormal e ProdutoPromocional).

Polimorfismo e Sobrescrita (@Override): Cálculo dinâmico do preço através do método getPrecoFinal(), comportando-se de maneira distinta para produtos normais e promocionais durante vendas e listagens.

Sobrecarga de Construtores: Múltiplos construtores na classe Cliente (com senha personalizada ou senha padrão).

Interfaces: Implementação da interface Autenticavel para padronizar o contrato de autenticação.

Encapsulamento e Atributos Estáticos: Proteção de atributos com modificadores private/protected, métodos acessores (getters/setters) e contadores globais (totalClientes e totalFuncionarios).

Manipulação de Coleções e Exceções: Uso extensivo de ArrayList e blocos try-catch para tratamento de entradas inválidas (NumberFormatException) e operações de I/O (IOException, EOFException, ClassNotFoundException).

📂 Estrutura de Arquivos

sistema-supermercado-java/
└── src/
    └── TrabalhoFinalPOO/
        ├── Main.java                          # Ponto de entrada da aplicação e inicialização do Admin
        ├── SupermercadoController.java        # Regras de negócio e controle central (MVC)
        ├── Autenticavel.java                  # Interface de autenticação
        ├── Pessoa.java                        # Classe base abstrata para usuários
        ├── Cliente.java                       # Modelo de Cliente
        ├── Funcionario.java                   # Modelo de Funcionário
        ├── Produto.java                       # Classe base abstrata para itens de estoque
        ├── ProdutoNormal.java                 # Subclasse de produto com preço integral
        ├── ProdutoPromocional.java            # Subclasse de produto com cálculo de desconto
        ├── Venda.java                         # Registro de transação e geração de cupom
        ├── AppendableObjectOutputStream.java  # Auxiliar para serialização incremental em arquivo
        ├── ArqCliente.java                    # Persistência de clientes (Clientes.txt)
        ├── ArqFuncionario.java                # Persistência de funcionários (Funcionarios.txt)
        ├── ArqProduto.java                    # Persistência de produtos (Produtos.txt)
        ├── ArqVendas.java                     # Persistência de vendas (Vendas.txt)
        └── Tela*.java                         # Classes de interface gráfica (Java Swing)


🚀 Como Executar o Projeto

Pré-requisitos

Java Development Kit (JDK) 8 ou superior instalado.

IDE Java de sua preferência (Eclipse, VS Code, IntelliJ IDEA) ou terminal.

Passo a passo

Clone este repositório ou extraia os arquivos do projeto:

git clone https://github.com/seu-usuario/sistema-supermercado-java.git


Abra o projeto na sua IDE e execute a classe Main.java localizada em src/TrabalhoFinalPOO/Main.java.

Na primeira execução, caso não exista nenhum funcionário cadastrado, o sistema criará automaticamente uma conta de administrador padrão:

Perfil: Sou Funcionário

CPF: 12345678900

Senha: admin

👥 Equipe de Desenvolvimento (Equipe 8)

André Cayare de Lima Souza – Camada Model e Persistência de Dados

Daniel Fernandes Ferreira – Camada View (Interface Gráfica em Java Swing)

Iarly Batista Mariano Maciel – Camada Controller e Regras de Negócio
