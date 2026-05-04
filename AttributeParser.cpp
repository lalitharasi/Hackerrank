#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <sstream>
#include <algorithm> // Required for std::remove

using namespace std;

int main() {
    int n, q;
    if (!(cin >> n >> q)) return 0;
    string line;
    getline(cin, line); // Consume the newline after n and q

    map<string, string> attributes;
    vector<string> tagStack;

    for (int i = 0; i < n; ++i) {
        getline(cin, line);

        if (line.substr(0, 2) == "</") {
            // Closing tag: remove the last tag from stack
            if (!tagStack.empty()) tagStack.pop_back();
        } else {
            // Opening tag: remove < and >
            line.erase(std::remove(line.begin(), line.end(), '<'), line.end());
            line.erase(std::remove(line.begin(), line.end(), '>'), line.end());
            
            stringstream ss(line);
            string tagName, attrName, equalSign, attrValue;
            
            ss >> tagName;
            tagStack.push_back(tagName);
            
            // Build current hierarchy path (e.g., tag1.tag2)
            string currentPath = "";
            for (size_t j = 0; j < tagStack.size(); ++j) {
                currentPath += tagStack[j] + (j == tagStack.size() - 1 ? "" : ".");
            }

            // Extract all attributes for this tag
            while (ss >> attrName >> equalSign >> attrValue) {
                // Remove quotes and the trailing > if any remained
                attrValue.erase(std::remove(attrValue.begin(), attrValue.end(), '\"'), attrValue.end());
                attributes[currentPath + "~" + attrName] = attrValue;
            }
        }
    }

    // Handle Queries
    for (int i = 0; i < q; ++i) {
        string query;
        getline(cin, query);
        if (attributes.count(query)) {
            cout << attributes[query] << endl;
        } else {
            cout << "Not Found!" << endl;
        }
    }

    return 0;
}
