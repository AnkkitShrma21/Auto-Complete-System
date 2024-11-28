<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Autocomplete System</title>
</head>
<body>
    <h1>Autocomplete System</h1>
    <p>
        This Java program implements an autocomplete system using a Trie data structure. 
        It allows users to input a prefix and get suggestions for words starting with that prefix from a given dictionary file.
    </p>

    <h2>Features</h2>
    <ul>
        <li><strong>Efficient Word Lookup:</strong> Uses a Trie (prefix tree) for quick retrieval of words.</li>
        <li><strong>Custom Dictionary:</strong> Load your own dictionary file to provide word suggestions.</li>
        <li><strong>Case-Insensitive Search:</strong> Handles words without considering case sensitivity.</li>
        <li><strong>Backtracking Algorithm:</strong> Uses depth-first search to explore possible word completions.</li>
    </ul>

    <h2>Usage</h2>
    <ol>
        <li>Clone or download the repository to your local machine.</li>
        <li>Place your dictionary file in the root directory of the project.</li>
        <li>Update the file path in the code (variable <code>dictionaryPath</code>) to point to your dictionary file.</li>
        <li>Compile and run the program using a Java compiler.</li>
        <li>Enter a prefix to receive autocomplete suggestions.</li>
    </ol>

    <h2>Code Overview</h2>
    <p>The main components of the code are:</p>
    <ul>
        <li><strong>TrieNode:</strong> Represents a node in the Trie.</li>
        <li><strong>Trie:</strong> Provides methods to insert words, search for prefixes, and retrieve autocomplete suggestions.</li>
        <li><strong>Autocompletesystem:</strong> The main class that integrates the Trie with a dictionary file and user input.</li>
    </ul>

    <h2>Example Dictionary</h2>
    <p>
        Below is an example of how your dictionary file (<code>Dictionary.txt</code>) might look:
    </p>
    <pre>
apple
application
apply
apt
banana
band
banner
cat
catch
category
    </pre>

    <h2>Running the Program</h2>
    <p>After running the program, you can input a prefix, such as <code>app</code>, and receive suggestions like:</p>
    <pre>
Suggestions:
apple
application
apply
    </pre>

    <h2>Requirements</h2>
    <ul>
        <li>Java Development Kit (JDK) installed on your machine.</li>
        <li>A text file containing words to use as the dictionary.</li>
    </ul>

    <h2>License</h2>
    <p>This project is licensed under the MIT License. Feel free to use and modify it.</p>

    <h2>Contributing</h2>
    <p>If you'd like to contribute to this project, feel free to submit a pull request or report issues in the repository.</p>
</body>
</html>
