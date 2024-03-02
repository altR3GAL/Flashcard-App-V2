package com.example.flashcardappv2

class p2 {
    enum class DeckState {
        EXHAUSTED,
        QUESTION,
        ANSWER,
    }

    // Basic functionality of any deck
    interface IDeck {
        // The state of the deck
        fun getState(): DeckState

        // The currently visible text
        // (or null if exhausted)
        fun getText(): String?

        // The number of question/answer pairs
        // (does not change when question are
        // cycled to the end of the deck)
        fun getSize(): Int

        // Shifts from question -> answer
        // (if not QUESTION state, returns the same IDeck)
        fun flip(): IDeck

        // Shifts from answer -> next question (or exhaustion);
        // if the current question was correct it is discarded,
        // otherwise cycled to the end of the deck
        // (if not ANSWER state, returns the same IDeck)
        fun next(correct: Boolean): IDeck
    }

    // create data class TaggedFlashCard that has elements prompt, answer, and tags in it
    data class TaggedFlashCard(val prompt: String, val answer: String, val tags: List<String>) {
        // check if certain tag is in the data class TaggedFlashCard (return true if tag is in the TaggedFlashCard's tags element)
        fun isTagged(tag: String): Boolean {
            return tag in this.tags
        }

        // using joinToString to create one string of all tags as well as output a string to summarize all elements in data class TaggedFlashCard
        fun fileFormat(): String {
            val tagExt = this.tags.joinToString(",")
            return "${this.prompt}$'|'${this.answer}$'|'$tagExt"
        }
    }
    data class TFCListDeck(private val listFlash: List<TaggedFlashCard>, private val stateFlash: DeckState = DeckState.QUESTION) : IDeck {
        // private val stateFlash = state
        // private val listFlash = list

        // override the getstate function to make it return the DeckState currently
        override fun getState(): DeckState {
            return stateFlash
        }

        // override the function getText to have it return the text assosciated with the current DeckState
        override fun getText(): String? {
            return when (stateFlash) {
                DeckState.EXHAUSTED -> null
                DeckState.QUESTION -> if (listFlash.isEmpty()) null else listFlash[0].prompt
                else -> if (listFlash.isEmpty()) null else listFlash[0].answer
            }
        }

        // override the function getSize to have it return the number of items in a list
        override fun getSize(): Int {
            return listFlash.size
        }

        // override the function flip so that the TFCDecklists DeckState changes to ANSWER if and only if the current DeckState is QUESTION
        override fun flip(): IDeck {
            if (stateFlash == DeckState.QUESTION) {
                return TFCListDeck(listFlash, DeckState.ANSWER)
            } else {
                return TFCListDeck(listFlash, stateFlash)
            }
        }

        // override the function next that takes in a boolean value and converts the TFCDecklists DeckState to QUESTION if and only if the current DeckState is ANSWER
        // if the "answer" was correct, then the current card is dropped from the list, if not, the current card is kept in the list
        override fun next(bool: Boolean): IDeck {
            if (stateFlash == DeckState.ANSWER) {
                val value1 = listFlash.take(1)
                val placeholder = if (bool) listFlash.drop(1) else listFlash.drop(1) + value1
                val placeState = if (placeholder.isEmpty()) DeckState.EXHAUSTED else DeckState.QUESTION
                return TFCListDeck(placeholder, placeState)
            }
            return TFCListDeck(listFlash, stateFlash)
        }
    }

    data class PerfectSquaresDeck(private val listInts: List<Int>, private val intState: DeckState = DeckState.QUESTION) : IDeck {
        // private val listInts = list2
        // private val intState = state2

        // override the getstate function to make it return the DeckState currently
        override fun getState(): DeckState {
            return intState
        }

        // override the function getText to have it return the text assosciated with the current DeckState
        override fun getText(): String? {
            if (intState == DeckState.EXHAUSTED || listInts.isEmpty()) {
                return null
            } else if (intState == DeckState.QUESTION) {
                return "${listInts[0]}^2 = ?"
            } else {
                return "${listInts[0]}^2 = ${listInts[0] * listInts[0]}"
            }
        }

        // override the function getSize to have it return the number of items in a list
        override fun getSize(): Int {
            return listInts.size
        }
        // citation marvin ghandi: helped me figure out that to use size I was to not add parenthesis after size

        // override the function flip so that the PerfectSquaresDeck DeckState changes to ANSWER if and only if the current DeckState is QUESTION
        override fun flip(): IDeck {
            if (intState == DeckState.QUESTION) {
                return PerfectSquaresDeck(listInts, DeckState.ANSWER)
            } else {
                return PerfectSquaresDeck(listInts, intState)
            }
        }

        // override the function next that takes in a boolean value and converts the PerfectSquaresDeck DeckState to QUESTION if and only if the current DeckState is ANSWER
        // if the "answer" was correct, then the current card is dropped from the list, if not, the current card is kept in the list
        override fun next(bool: Boolean): IDeck {
            if (intState == DeckState.ANSWER) {
                val value1 = listInts.take(1)
                val placeholder = if (bool) listInts.drop(1) else listInts.drop(1) + value1
                val placeState = if (placeholder.isEmpty()) DeckState.EXHAUSTED else DeckState.QUESTION
                return PerfectSquaresDeck(placeholder, placeState)
            }
            return PerfectSquaresDeck(listInts, intState)
        }
    }
}