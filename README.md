# UNIWallet Java Library

The uniwallet java library provides a covenient way for applications written in
java to interact with uniwallet api.

## UNIWallet Documentation

Find the uniwallet documentation here [uniwallet docs](https://uniwalletapi1.docs.apiary.io)

## Installation

You'd currently need to install manually with our .jar file

*   UNIWallet JAR from https://github.com/philip-nunoo/uniwallet-java/releases/latest

### Maven

Coming soon

### Gradle

Coming soon

## Usage

### Getting started

Available API

```java
public class Main {

    private static String MERCHANT_ID = "";
    private static String API_KEY = "";
    private static String PRODUCT_ID = "";

    public static void main(String[] args) throws IOException {
        Transflow transflow = new Transflow(MERCHANT_ID, API_KEY, PRODUCT_ID);
        UniWallet uniWallet = new UniWallet(transflow);

        // do something awesome
    }
}
```

Obtain your `MERCHANT_ID`, `API_KEY` and `PRODUCT_ID` from uniwallet.

### Obtaining networks

```Java
        // your previous awesome code
        String[] networks = uniWallet.getNetworks();
        //
```

### Credit customer

```java
        // your prevous awesome code
        UniWalletResponse uniWalletResponse = uniWallet.creditCustomer(refNumber, msisdn, amount, network, narration);

        if (uniWalletResponse.isSuccessful()) {
            // do something awesome
        } else {
            System.out.println(uniWalletResponse.getResponseMessage());
        }


        // your next awesome code
```

### Debit customer

```java
        // your prevous awesome code
        UniWalletResponse uniWalletResponse = uniWallet.debitCustomer(refNumber, msisdn, amount, network, voucher, narration);

        if (uniWalletResponse.isSuccessful()) {
            // do something awesome
        } else {
            System.out.println(uniWalletResponse.getResponseMessage());
        }
        // your next awesome code
```

## Todo

*   Callback response
*   write tests for credit customer
*   write tests for debit customer
*   write tests for the various error response

## Other api libraries

*   JAVA: https://github.com/philip-nunoo/uniwallet-java
*   PHP: https://github.com/philip-nunoo/uniwallet-php
*   NODE: https://github.com/philip-nunoo/uniwallet-node
*   RUBY: https://github.com/philip-nunoo/uniwallet-ruby
*   PYTHON: https://github.com/philip-nunoo/uniwallet-python
