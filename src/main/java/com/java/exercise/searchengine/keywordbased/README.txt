search engines :: advanced algorithms and parallel searching techniques
 
Description: 
A group of web pages has been classified by associating a list of keywords, given in decreasing order of relevance, 
with each page (i.e., the order of keywords is from the most specific keyword to the least specific). 
For example, on the TopGear website a page on reviews of Ford cars may have the keywords: Ford, Car, Review in that order; the most relevant keyword is Ford.
 
Queries also include a list of keywords, again from most to least relevant. 
For example, in a query consisting of the keyword Ford followed by the keyword Car, Ford is more important than Car.

TODO: In this problem you are to determine the top five (or fewer) pages that match each of an arbitrary number of queries.

TODO Algorithm:
To determine the <strength of the relationship between a query and a web page>, 
assume the keywords for each page and each query are assigned integer weights, in descending order, 
starting with N, where N is the maximum number of keywords allowed for a web page and query.

The strength of the relationship is --> the sum of the products of the weights associated with
each keyword that appears both in the webpage list and the query list.

For example, assume the following web pages and keyword lists:
Page 1: Ford (pk=8), Car (pk=7), Review  (pk=6)
Page 2: Toyota  (pk=8), Car  (pk=7)
Page 3: Car  (pk=8), Ford  (pk=7)
 
sk --> Search key, pk --> page key, nm --> no match

For N equal 8, a query with keywords Ford(sk=8) and Car(sk=7) in that order yields the following strength ratings.
Page 1: (8x8 + 7x7) = 113 	--> pk=8*sk=8 + pk=7*sk=7
Page 2: (7x7) = 49 			--> (for Ford) nm=0 + pk=7*sk=7
Page 3: (8x7)(7x8) = 112.	--> pk=7*sk=8 + pk=8*sk=7

Similarly, a query with keywords Ford(sk=8) and Review(sk=7) yields the following strength ratings.
Page 1: (8x8 + 7x6) = 106  	--> pk=8*sk=8 + pk=6*sk=7
Page 2: = 0					--> (for Ford) nm=0  + (for Review) nm=0 
Page 3: (8x7) = 56			--> pk=7*sk=8 + (for Review) nm=0 


**************************************************************************
Code letters P and Q denote a page and a query
case being insignificant for keywords
Do not list pages that have no relationship (zero strength), even if fewer than five pages are identified.
consider the impact of nested pages.

**************************************************************************
Reserch:
Trie : data structure --> prefix based search, sort the string lexographically in the trie. Alternative is use hash table, but with hashtable we can't do prefix based search and also a regular hashtable take more space than a trie. 
	- Insertion into a trie

	
Hashtable/LinkedHashMap<page_name, Arraylist<page keys Bean>> or Arraylist<page keys Bean>, where page key bean contains pagename, key, weight
Query Bean ---> searchText, Arraylist<Search key bean> --> key, weight

getStrength(search_key_bean_list, page_key_bean_list) --> 
			for loop search_key_bean_list --> ford, car
				for loop page_key_bean_list --> car, ford
					strength += if key matched, get weight and multiply them.
	
construct a set of ResultPage bean, this result bean contains page name, page keys, search keys, strength ??? nested
Sort this set based on comparator, --> based on strength				
	

Composite design pattern - for nested pages.
Interpreter - design pattern
