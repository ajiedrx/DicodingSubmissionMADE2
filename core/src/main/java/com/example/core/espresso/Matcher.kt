package com.example.core.espresso

import android.content.res.Resources
import android.view.View
import android.widget.TextView

import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher


/**
 * Original source from Espresso library, modified to handle spanned fields
 *
 * Returns a matcher that matches a descendant of [TextView] that is
 * displaying the string associated with the given resource id.
 *
 * @param resourceId
 * the string resource the text view is expected to hold.
 */
fun withText(resourceId: Int): Matcher<View?> {
    return object : BoundedMatcher<View?, TextView?>(TextView::class.java) {
        private var resourceName: String? = null
        private var expectedText: String? = null
        override fun describeTo(description: Description) {
            description.appendText("with string from resource id: ")
            description.appendValue(resourceId)
            if (null != resourceName) {
                description.appendText("[")
                description.appendText(resourceName)
                description.appendText("]")
            }
            if (null != expectedText) {
                description.appendText(" value: ")
                description.appendText(expectedText)
            }
        }

        override fun matchesSafely(textView: TextView?): Boolean {
            if (null == expectedText) {
                try {
                    expectedText = textView?.resources?.getString(
                        resourceId
                    )
                    resourceName = textView?.resources?.getResourceEntryName(resourceId)
                } catch (ignored: Resources.NotFoundException) {
                    /*
                     * view could be from a context unaware of the resource
                     * id.
                     */
                }
            }
            return if (null != expectedText) {
                expectedText == textView?.text
                    .toString()
            } else {
                false
            }
        }
    }
}