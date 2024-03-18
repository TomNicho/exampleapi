package uk.example.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uk.example.api.Data;
import uk.example.api.core.APIR;
import uk.example.api.database.tables.*;

@RestController
public class APIController {

    @Autowired
    private Data data;

    /*
    // General
    */

    @GetMapping("/products")
    public @ResponseBody APIR productsGET() {
        return new APIR(true, data.products.findAll());
    }

    @GetMapping("/variations")
    public @ResponseBody APIR variationsGET() {
        return new APIR(true, data.variations.findAll());
    }

    @GetMapping("/stocks")
    public @ResponseBody APIR stocksGET() {
        return new APIR(true, data.stocks.findAll());
    }

    /*
    // Products
    */ 

    @GetMapping("/product/{id}")
    public @ResponseBody APIR productGET(@PathVariable Long id) {
        Optional<Product> pOptional = data.products.findById(id);
        if (pOptional.isPresent()) return new APIR(true, pOptional.get());
        else return new APIR(false, null);
    }

    @PostMapping("/product")
    public @ResponseBody APIR productCreatePOST(@RequestBody Product product) {
        if (product != null) {
            data.products.save(product);
            return new APIR(true, null);
        }

        return new APIR(false, null);
    }

    @PutMapping("/product/{id}")
    public @ResponseBody APIR productUpdatePUT(@RequestBody Product product, @PathVariable Long id) {

        Optional<Product> pOptional = data.products.findById(id);
        if (pOptional.isPresent() && product != null) {
            product.setId(id);
            data.products.save(product);
            return new APIR(true, null);
        }

        return new APIR(false, null);
    }

    @DeleteMapping("/product/{id}")
    public @ResponseBody APIR productDeleteDELETE(@PathVariable Long id) {
        Optional<Product> pOptional = data.products.findById(id);
        if (pOptional.isPresent()) {
            data.products.delete(pOptional.get());
            return new APIR(true, null);
        }

        return new APIR(false, null);
    }

    /*
    // Variations
    */

    @GetMapping("/variation/{id}")
    public @ResponseBody APIR variationGET(@PathVariable Long id) {
        Optional<Variation> vOptional = data.variations.findById(id);
        if (vOptional.isPresent()) return new APIR(true, vOptional.get());
        else return new APIR(false, null);
    }

    @GetMapping("/product/{id}/variations")
    public @ResponseBody APIR productVariationsGET(@PathVariable Long id) {
        Optional<Product> pOptional = data.products.findById(id);
        if (pOptional.isPresent()) return new APIR(true, pOptional.get().getVariations());
        else return new APIR(false, null);
    }

    @PostMapping("/product/{id}/variation")
    public @ResponseBody APIR productVariationPOST(@PathVariable Long id, @RequestBody Variation variation) {
        Optional<Product> pOptional = data.products.findById(id);
        if (pOptional.isPresent() && variation != null) {
            variation.setProduct(pOptional.get());
            data.variations.save(variation);
            return new APIR(true, null);
        } else return new APIR(false, null);
    }

    @PutMapping("/variation/{id}")
    public @ResponseBody APIR variationPUT(@PathVariable Long id, @RequestBody Variation variation) {
        Optional<Variation> vOptional = data.variations.findById(id);
        if (vOptional.isPresent() && variation != null) {
            variation.setId(id);
            variation.setProduct(vOptional.get().getProduct());
            data.variations.save(variation);
            return new APIR(true, null);
        } else return new APIR(false, null);
    }

    @DeleteMapping("/variation/{id}")
    public @ResponseBody APIR variationDELETE(@PathVariable Long id) {
        Optional<Variation> vOptional = data.variations.findById(id);
        if (vOptional.isPresent()) {
            data.variations.delete(vOptional.get());
            return new APIR(true, null);
        } else return new APIR(false, null);
    }

    @GetMapping("/stock/{id}")
    public @ResponseBody APIR stockGET(@PathVariable Long id) {
        Optional<Stock> sOptional = data.stocks.findById(id);
        if (sOptional.isPresent()) return new APIR(true, sOptional.get());
        else return new APIR(false, null);
    }

    @GetMapping("/variation/{id}/stocks")
    public @ResponseBody APIR variationStocksGET(@PathVariable Long id) {
        Optional<Variation> vOptional = data.variations.findById(id);
        if (vOptional.isPresent()) return new APIR(true, vOptional.get().getStocks());
        else return new APIR(false, null);
    }

    @PostMapping("/variation/{id}/stock")
    public @ResponseBody APIR variationStockPOST(@PathVariable Long id, @RequestBody Stock stock) {
        Optional<Variation> vOptional = data.variations.findById(id);
        if (vOptional.isPresent() && stock != null) {
            stock.setVariation(vOptional.get());
            data.stocks.save(stock);
            return new APIR(true, null);
        } else return new APIR(false, null);
    }

    @PutMapping("/stock/{id}")
    public @ResponseBody APIR stockPUT(@PathVariable Long id, @RequestBody Stock stock) {
        Optional<Stock> sOptional = data.stocks.findById(id);
        if (sOptional.isPresent() && stock != null) {
            stock.setId(id);
            stock.setVariation(sOptional.get().getVariation());
            data.stocks.save(stock);
            return new APIR(true, null);
        } else return new APIR(false, null);
    }

    @DeleteMapping("/stock/{id}")
    public @ResponseBody APIR stockDELETE(@PathVariable Long id) {
        Optional<Stock> sOptional = data.stocks.findById(id);
        if (sOptional.isPresent()) {
            data.stocks.delete(sOptional.get());
            return new APIR(true, null);
        } else return new APIR(false, null);
    }
}