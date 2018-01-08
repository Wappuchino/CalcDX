/*
 ***************************************************************************************************
 * The IParser represents any expression parser. It provides access the the parsing functionality  *
 * of the parser.                                                                                  *
 *                                                                                                 *
 * Note that parsers only return the first term of the expression that would be evaluated using    *
 * stamdard order of operations. However, keep in mind that the terms form a parse tree which      *
 * makes the first term also the root of the parse tree, meaning that all terms are accessible     *
 * through the first (also the root) term.                                                         *
 *                                                                                                 *
 * - Wappuchino                                                                                    *
 **************************************************************************************************/

package com.thebois.wappuchino.calcdx.solver;

/**
 * The IParser interface exposes the parsing functionality of a parser.
 * It also represents the base type for all expression parsers.
 */
interface IParser
{
    /**
     * The parse function of the parser. It accepts a string the format accepted by the parser
     * and attempts to parse the string into an expression. Should the string be improperly
     * formatted, the parser will return null; otherwise, it returns the first term (as in the
     * first term that should happen when order of operations is applied)
     *
     * @param expression A single formatted token array representing a mathematical expression
     * @return The first term that would be evaluated in standard order of operations
     */
    ITerm parse(String[] expression);
}