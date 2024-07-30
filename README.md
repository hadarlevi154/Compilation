HW in the course "Compilation" as part of my B.Sc. in Computer Science at Tel Aviv University.

An implementation of an entire compiler for L programs.

HW1- 
Implemented a lexical scanner based on the open source tool JFlex. 
The input for the scanner is a single text file containing a L program,
and the output is a (single) text file containing a tokenized representation of the input.

HW2- 
Implemented a CUP based parser on top of the JFlex scanner from HW1. 
The input for the parser is a single text file containing a L program, 
and the output is a (single) text file indicating whether the input program is syntactically valid or not. 
In addition to that, whenever the input program has correct syntax, 
the parser should internally create the abstract syntax tree (AST).

HW3-
Implemented a semantic analyzer that recursively scans the AST produced by CUP, 
and checks if it contains any semantic errors. 
The input for the semantic analyzer is a (single) text file containing a L program,
and the output is a (single) text file indicating whether the input program is semantically valid or not. 
In addition to that, whenever the input program is valid semantically, 
the semantic analyzer will add meta data to the abstract syntax tree, 
which is needed for later phases (code generation and optimization).

HW4-
Implemented the code generation phase for L programs. The chosen destination language is MIPS assembly, favoured for it
straightforward syntax, complete toolchain and available tutorials. 
The exercise can be roughly divided into three parts as follows: 
(1) recursively traverse the AST to create an intermediate representation (IR) of the program. 

(2) Translate IR to MIPS instructions, but use an unbounded number of temporaries instead of registers. 

(3) Perform liveness analysis, build the interference graph, and allocate those hundreds (or so) temporaries into 10 physical registers.

The input for this last exercise is a (single) text file, containing a L program,
and the output is a (single) text file that contains the translation of the input
program into MIPS assembly.
