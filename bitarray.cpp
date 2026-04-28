#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    unsigned int N, S, P, Q;
    if (!(cin >> N >> S >> P >> Q)) return 0;

    unsigned long long MOD = 2147483648ULL; // 2^31
    
    unsigned int current = S % MOD;
    unsigned int last = current;
    unsigned int count = 1;

    for (unsigned int i = 1; i < N; ++i) {
        // Use unsigned int overflow behavior or explicit modulo
        current = (last * (unsigned long long)P + Q) % MOD;
        
        if (current != last) {
            count++;
            last = current;
        } else {
            // If the sequence stabilizes or enters a 1-step cycle early
            break;
        }
    }

    cout << count << endl;   
    return 0;
}