// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> =
        customers.filter { checkOrderCount(it.orders) }.toSet()

fun checkOrderCount(order: List<Order>) : Boolean{
    val (delivered, undelivered) = order.partition { it.isDelivered }
    return undelivered.size > delivered.size
}