package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    return this.customers.filter {
        c ->
        c.orders.flatMap { o -> o.products }
                .any { p -> p.equals(product) }
    }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    return this.orders.filter { o -> o.isDelivered }
            .flatMap { o -> o.products }
            .maxBy { p -> p.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    return this.customers.flatMap { c -> c.orders }
            .flatMap { o -> o.products }
            .filter { p -> p.equals(product) }.count()
}
