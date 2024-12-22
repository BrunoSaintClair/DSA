package DataStructures

// <T>  === tipo genérico

class Node<T>(
    var value: T? = null,
    var next: Node<T>? = null,
    var previous: Node<T>? = null
)