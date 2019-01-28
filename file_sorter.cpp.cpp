
/*
 * homework1.cpp
 *
 *  Part 1
 *	read in a list of unsorted words into an array
 *	using a second set of words (read in from a file) see if the word
 *	is in the array or not. Use a linear search for this.
 *
 *	Part 2
 *	read in a second set of sorted words into an array
 *	using a second set of words (read in from a file) see if the word
 *	is in the array or not using a binary search.
 *
 *  Created on: Jan 22, 2019
 *  Author: npc170001 (Nisha Chandra)
 *  Class:	CS1337
 *  Instructor: D. Vogel
 *
 */

// Includes here
#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>
#include <cstdlib>

// Namespace
using namespace std;

const int MAX_WORDS = 1000;

// read "size" string from file "fileName" into the array "array"
bool readWords (string array[], int size, string fileName);


/************************************************************************
 * using linear search to see if word "wordToFind" is in array "words".
 * There are "size" words in the array.
 *
 * Return -1 if the word is not found and the index of the found word in
 * the array if it is found.
*************************************************************************/
int linearSearch (string wordToFind, const string words[], int size);


/************************************************************************
 * using binary search to see if word "wordToFind" is in array "words".
 * There are "size" words in the array.
 *
 * Return -1 if the word is not found and the index of the found word in
 * the array if it is found.
*************************************************************************/
int binarySearch (string wordToFind, const string words[], int size);


int main()
{
	// read in the sorted and unsorted words and the words to be found.
	// call the linear and binary search functions to try and find the
	// words.

	bool result;
	string words[MAX_WORDS];
	const int MAX_FIND = 20;
	string findWords[MAX_FIND];
	string inputFileName;

	// first read in the words we will search for
	inputFileName = "findWords.txt";
	result = readWords (findWords, MAX_FIND, inputFileName);

	if (!result)
	{
		// file does not exist
		cout << "The file " << inputFileName << " could not be opened" << endl;
		cout << endl;
		exit(4);
	}

	// get unsorted words and do a linear search using those words
	inputFileName = "unsortedWords.txt";
	cout << "Read words from " << inputFileName << endl;

	result = readWords (words, MAX_WORDS, inputFileName);

	if (result)
	{
		// we were able to read in the words. Now do the linear search on
		// the words to be found
		cout << "The unsorted words were successfully read in" << endl;
		cout << endl;

		for (int index = 0; index < MAX_FIND; index++)
		{
			int position = linearSearch (findWords[index], words, MAX_WORDS);

			if (position < 0)
			{
				// the word was not found
				cout << "The word \"" << findWords[index] << "\" was not found " << endl;
			}
			else
			{
				// the word was found
				cout << "The word \"" << findWords[index] << "\" was found at index ";
				cout << position << " " << endl;

			}
		}
	}
	else
	{
		// the file does not exist
		cout << "The file " << inputFileName << " could not be opened" << endl;
	}

	// get sorted words and use binary search
	inputFileName = "sortedWords.txt";
	cout << endl;
	cout << "Read words from " << inputFileName << endl;

	result = readWords(words, MAX_WORDS, inputFileName);

	if (result)
	{
		// we were able to read in the words. Now do the binary search on
		// the words to be found
		cout << "The sorted words were successfully read in" << endl;
		cout << endl;

		for (int index = 0; index < MAX_FIND; index++)
		{
			int position = binarySearch (findWords[index], words, MAX_WORDS);

			if (position < 0)
			{
				// the word was not found
				cout << "The word \"" << findWords[index] << "\" was not found " << endl;

			}
			else
			{
				// the word was found
				cout << "The word \"" << findWords[index] << "\" was found at index ";
				cout << position << " " << endl;
				//cout << endl;
			}
		}
	}
	else
	{
		// the file does not exist
		cout << "The file " << inputFileName << " could not be opened" << endl;
	}

	return 0;
}

/**************************************************************************
  *
  * readWords(): Method to read in the words from the findWords.txt
  * file.  These words are copied into an array and used later for
  * searching from the unsorted and sorted arrays with the
  * linear search and binary search methods.
  *
  * Return: bool
  * Parameters: string [], int, string
  *
**************************************************************************/
bool readWords(string array[], int size, string fileName)
{
	//creating an file object for reading input into the array
	ifstream inputFile;
	inputFile.open (fileName);

	int index = 0;  //setting initial index of array to 0

	if (inputFile) //if statement to test whether file object was successfully opened
	{

		while (inputFile && (index < size))
		{
			inputFile >> array[index]; //reading from file into the array
			//cout << "Word is - " << array[index] << " at index " << index << endl;
			index++;  //update index by 1 for every iteration
		}
		inputFile.close(); //closing the file
		return true;
	}

	else
	{
		return false;
	}
}

/************************************************************************
 *
 * linearSearch(): This method is used to see if word "wordToFind" is
 * in array "words". There are "size" words in the array.
 *
 * Parameters: string, const string[], int
 * Return: -1 if the word is not found and the index of the found word in
 * the array if it is found.
 *
*************************************************************************/
int linearSearch (string wordToFind, const string words[], int size)
{
	int index = 0; 			//used as a subscript to search array
	int position = -1; 		//to record position of wordToFind in array words
	bool found = false; 	//flag to indicate whether wordToFind is found

	while ((index < size) && (!found))
	{
		if (wordToFind == (words[index])) //if the word is found
		{
			found = true;
			position = index;		      //record the index of where the word was found
		}
		index++; 						  //go to the next element
	}

return position;						  //returns index or -1
}

/************************************************************************
 * binarySearch(): The binary search method is used to see if word
 * "wordToFind" is in array "words". There are "size" words in the array.
 *
 * Parameters: string, const string[], int
 * Return -1 if the word is not found and the index of the found word in
 * the array if it is found.
*************************************************************************/
int binarySearch(string wordToFind, const string words[], int size)
{
	int first = 0; 			//first array element
	int last = size - 1; 	//last array element
	int middle;
	int position = -1; 		//current position
	bool found = false; 	//flag to indicate whether wordToFind has been found

	while(!found && first <= last)
	{
		middle = first + (last - first) / 2; 	//calculating midpoint of array
		if(words[middle] == wordToFind)  		//if wordToFind is found in the middle of the array
		{
			found = true;
			position = middle;
		}
		else if (words[middle] > wordToFind) 	//wordToFind is found in lower half to the left of midpoint
		{
			last = middle - 1;
		}
		else
			first = middle + 1;         		//wordToFind is found in upper half to the right of midpoint
	}
	return position;
}

