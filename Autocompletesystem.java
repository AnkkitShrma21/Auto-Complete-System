import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        current.isEndOfWord = true;
    }

    // Find the node corresponding to the last character of the prefix
    private TrieNode findNode(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            TrieNode node = current.children.get(ch);
            if (node == null) {
                return null;
            }
            current = node;
        }
        return current;
    }

    // Retrieve autocomplete suggestions
    public List<String> getAutocompleteSuggestions(String prefix) {
        List<String> suggestions = new ArrayList<>();
        TrieNode prefixNode = findNode(prefix);
        if (prefixNode != null) {
            dfs(prefixNode, new StringBuilder(prefix), suggestions);
        }
        return suggestions;
    }

    // Depth-first search to gather all words starting from a given node
    private void dfs(TrieNode node, StringBuilder currentWord, List<String> suggestions) {
        if (node.isEndOfWord) {
            suggestions.add(currentWord.toString());
        }
        for (char ch : node.children.keySet()) {
            currentWord.append(ch);
            dfs(node.children.get(ch), currentWord, suggestions);
            currentWord.deleteCharAt(currentWord.length() - 1); // backtrack
        }
    }
}

public class Autocompletesystem {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Load the dictionary from a file
        String dictionaryPath = "Dictionary.txt"; // Path to your dictionary file
        loadDictionary(trie, dictionaryPath);

        // Taking input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a prefix to autocomplete:");
        String prefix = scanner.nextLine();

        // Fetching and displaying autocomplete suggestions
        List<String> suggestions = trie.getAutocompleteSuggestions(prefix);
        if (suggestions.isEmpty()) {
            System.out.println("No suggestions found for prefix: " + prefix);
        } else {
            System.out.println("Suggestions:");
            for (String suggestion : suggestions) {
                System.out.println(suggestion);
            }
        }
        scanner.close();
    }

    // Method to load dictionary from a file and insert words into the Trie
    public static void loadDictionary(Trie trie, String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String word;
            while ((word = br.readLine()) != null) {
                word = word.trim();  // Remove leading/trailing spaces
                if (!word.isEmpty()) {
                    trie.insert(word.toLowerCase());  // Insert word into the Trie
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the dictionary file: " + e.getMessage());
        }
    }
}
