/*
 ***************************************************************************************************
 * The AbstractTerm class is an abstract class that provides a basic implementation of the storage *
 * of child terms. For this particular class, the child terms are stored into a fixed-length array *
 * whose size can be specified at the constructor of this class.                                   *
 *                                                                                                 *
 * - Wappuchino                                                                                    *
 **************************************************************************************************/

package com.thebois.wappuchino.calcdx.solver;

/**
 * The abstract term class is an abstract class that follows the contract of the ITerm interface.
 * This class provides a basic storage implementation of child terms.
 */

public abstract class AbstractTerm implements ITerm {
    /**
     * An protected array of terms that represent the child terms of this term.
     */
    protected ITerm[] children;

    /**
     * The default constructor which presumes the size of the child storage array to be zero.
     */
    protected AbstractTerm()
    {
        //A call to the constructor which takes a size argument for the size of the child array
        //Zero is passed in to specify that the child array be of size zero
        this(0);
    }

    /**
     * An overloaded constructor which takes a single integer argument for the size of the child
     * storage array. The constructor will initialize the child array to the given size and ensure
     * that each element is initialized to null.
     *
     * @param size The size that the child storage array should be initialized to
     */
    protected AbstractTerm(int size)
    {
        //Creates a storage array of the given size
        //The elements are by default null due to how Java initializes arrays of objects
        children = new ITerm[size];
    }

    /**
     * An implementation of the get children function of the term interface. It returns a view
     * to the child storage array.
     *
     * This particular implementation will return a view that allows changes in the view to be
     * reflected in the actual storage array.
     *
     * @return A view of the child terms of this term
     */
    @Override
    public ITerm[] getChildren()
    {
        return children;
    }
}
