package org.kotlin99.binarytrees

import com.natpryce.hamkrest.assertion.assertThat
import org.junit.Test
import org.kotlin99.binarytrees.Tree
import org.kotlin99.binarytrees.Tree.End
import org.kotlin99.binarytrees.Tree.Node
import org.kotlin99.common.hasSameElementsAs


fun <T> Tree<T>.valuesAtLevel(n: Int): List<T> =
        if (this == End) {
            emptyList()
        } else if (this is Node<T>) {
            if (n == 1) listOf(this.value)
            else left.valuesAtLevel(n - 1) + right.valuesAtLevel(n - 1)
        } else {
            this.throwUnknownImplementation()
        }


class P62Test {
    @Test fun `collect node values at particular level`() {
        val tree = Node("a", Node("b"), Node("c", Node("d"), Node("e")))
        assertThat(tree.valuesAtLevel(0), hasSameElementsAs(emptyList()))
        assertThat(tree.valuesAtLevel(1), hasSameElementsAs(listOf("a")))
        assertThat(tree.valuesAtLevel(2), hasSameElementsAs(listOf("b", "c")))
        assertThat(tree.valuesAtLevel(3), hasSameElementsAs(listOf("d", "e")))
        assertThat(tree.valuesAtLevel(4), hasSameElementsAs(emptyList()))
    }
}