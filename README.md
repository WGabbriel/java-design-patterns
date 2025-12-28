# 🏪 Store API - Java Design Patterns

Uma aplicação Spring Boot que demonstra a implementação prática de **Padrões de Design** (Design Patterns) através de um sistema de loja virtual.

## 📋 Sobre o Projeto

Este projeto foi desenvolvido como parte do desafio da **DIO (Digital Innovation One)** para explorar conceitos de **Padrões de Projeto** na prática. A aplicação simula um sistema de e-commerce simples onde os usuários podem criar pedidos com diferentes métodos de pagamento e opções de frete.

## 🎯 Padrões de Design Implementados

### 1. **Facade Pattern** 🎭

- **Classe:** `OrderFacade`
- **Propósito:** Simplifica a interface complexa do sistema de pedidos
- **Funcionalidade:** Coordena o processo de criação de pedidos, integrando pagamento e cálculo de frete de forma transparente

### 2. **Factory Pattern** 🏭

- **Classe:** `PaymentFactory`
- **Propósito:** Centraliza a criação de objetos de pagamento
- **Funcionalidade:** Cria instâncias de diferentes tipos de pagamento (PIX, Cartão de Crédito) baseado no parâmetro fornecido

### 3. **Strategy Pattern** ⚡

- **Interface:** `ShippingStrategy`
- **Implementações:**
  - `NormalShipping` - Frete normal
  - `ExpressShipping` - Frete expresso
- **Propósito:** Permite trocar algoritmos de cálculo de frete dinamicamente

### 4. **Singleton Pattern** 🎯

- **Implementação:** Através das anotações Spring (`@Configuration`, `@Service`, `@Component`)
- **Classes:** `AppConfig`, `OrderFacade`, `PaymentFactory`, `NormalShipping`, `ExpressShipping`
- **Propósito:** Garante que existe apenas uma instância de cada bean no contexto do Spring
- **Funcionalidade:** O Spring IoC Container gerencia automaticamente o ciclo de vida e garante a unicidade das instâncias

## 🛠 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 4.0.1**
- **Spring Web**
- **SpringDoc OpenAPI (Swagger)**
- **Maven**

## 🚀 Como Executar

### Pré-requisitos

- Java 17 ou superior
- Maven 3.6+

### Passos

1. **Clone o repositório:**

```bash
git clone <url-do-repositorio>
cd java-design-patterns
```

1. **Execute a aplicação:**

```bash
./mvnw spring-boot:run
```

1. **Acesse a aplicação:**

- **API:** <http://localhost:8080>
- **Documentação (Swagger):** <http://localhost:8080/swagger-ui.html>

## 📖 API Endpoints

### POST /orders

Cria um novo pedido aplicando os padrões implementados.

**Parâmetros:**

- `value` (double, obrigatório): Valor total do pedido
- `payment` (string, obrigatório): Método de pagamento (`PIX` ou `CREDIT`)
- `shipping` (string, opcional): Tipo de frete (`normal` ou `express`)

**Exemplo de uso:**

```bash
curl -X POST "http://localhost:8080/orders?value=100.00&payment=PIX&shipping=express"
```

**Resposta:**

```
=== Store Spring ===
Order received with total value of $125.00
```

## 🏗 Arquitetura do Projeto

```
src/main/java/com/wgabbriel/dio/store/
├── config/
│   └── AppConfig.java          # Configurações da aplicação
├── controller/
│   └── OrderController.java    # Controlador REST
├── facade/
│   └── OrderFacade.java        # Facade Pattern
├── payment/
│   ├── Payment.java           # Interface Strategy
│   ├── PaymentFactory.java    # Factory Pattern
│   ├── PixPayment.java        # Implementação PIX
│   └── CreditCardPayment.java # Implementação Cartão
├── shipping/
│   ├── ShippingStrategy.java  # Interface Strategy
│   ├── NormalShipping.java    # Frete normal
│   └── ExpressShipping.java   # Frete expresso
└── StoreApplication.java      # Classe principal
```

## 🎓 Conceitos Demonstrados

### Facade Pattern

O `OrderFacade` encapsula a complexidade de:

- Criação de objetos de pagamento
- Cálculo de frete
- Processamento do pedido
- Formatação da resposta

### Factory Pattern

O `PaymentFactory` abstrai a criação de objetos, permitindo:

- Adição de novos métodos de pagamento sem modificar o código cliente
- Centralização da lógica de criação
- Maior flexibilidade e manutenibilidade

### Strategy Pattern

As strategies de frete permitem:

- Troca dinâmica de algoritmos de cálculo
- Extensibilidade para novos tipos de frete
- Separação de responsabilidades

### Singleton Pattern

O Spring Framework implementa o padrão Singleton através de:

- **Gerenciamento automático de beans:** Cada classe anotada com `@Component`, `@Service`, `@Configuration` torna-se um singleton
- **Injeção de dependência:** Garante que a mesma instância seja reutilizada em toda a aplicação
- **Controle de ciclo de vida:** O Spring IoC Container gerencia criação, inicialização e destruição das instâncias

## 🧪 Testando a Aplicação

### Cenário 1: Pedido com frete normal

```bash
curl -X POST "http://localhost:8080/orders?value=150.00&payment=CREDIT&shipping=normal"
```

### Cenário 2: Pedido com frete expresso

```bash
curl -X POST "http://localhost:8080/orders?value=75.00&payment=PIX&shipping=express"
```

### Cenário 3: Pedido sem especificar frete (usa normal por padrão)

```bash
curl -X POST "http://localhost:8080/orders?value=200.00&payment=PIX"
```

## 📚 Recursos de Aprendizado

Este projeto demonstra na prática:

- ✅ Como simplificar interfaces complexas com **Facade**
- ✅ Como criar objetos de forma flexível com **Factory**  
- ✅ Como trocar algoritmos dinamicamente com **Strategy**
- ✅ Como garantir instâncias únicas com **Singleton** (via Spring)
- ✅ Integração com **Spring Boot** e **Injeção de Dependência**
- ✅ Documentação automática com **OpenAPI/Swagger**

**Desenvolvido com 💻 e ☕ para o desafio da DIO**
