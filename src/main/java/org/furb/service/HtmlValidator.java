package org.furb.service;

import org.furb.dataStructure.Stack;
import org.furb.dataStructure.StaticList;
import org.furb.dataStructure.sort.AbstractSort;
import org.furb.dataStructure.sort.OptimizedBubbleSort;
import org.furb.exception.IllegalTagsSequence;
import org.furb.exception.InvalidHtmlStructureException;
import org.furb.exception.InvalidTagException;
import org.furb.model.Tag;


public class HtmlValidator {
    private final Stack<Tag> tagStack;
    public final StaticList<Tag> tagList;

    public HtmlValidator() {
        tagStack = new Stack<>();
        tagList = new StaticList<>();
    }

    public boolean isValidTags(String[] tagsContent) {
        for (String content : tagsContent) {
            Tag tag = new Tag(content);
            if (!tag.isValidTag()) throw new InvalidTagException("A tag " + content + " é inválida! Sua estrutura não segue os requisitos");

            updateTagStack(tag);
        }
        return true;
    }

    private void updateTagStack(Tag tag) {
        if (!tag.isFinal()) {
            tagStack.push(tag);
            putFrequency(tag);
        }

        if (tag.isFinal() && !tag.isSingleton()) {
            if (tagStack.isEmpty()) throw new InvalidHtmlStructureException("A tag " + tag.getContent() + " é inválida! Não há tags para fechar");

            Tag lastTag = tagStack.pop();
            String expectedTag = lastTag.getContent().replace("<", "</");
            if (!expectedTag.equalsIgnoreCase(tag.getContent())) throw new IllegalTagsSequence("A tag " + tag.getContent() + " é inválida, existe uma tag para fechar ainda! A tag esperada é " + lastTag.getContent().replace("<", "</"));
        }
    }


    private void putFrequency(Tag tag) {
        int position = tagList.search(tag);

        if (position < 0) {
            tag.setFrequency(1);
            tagList.insert(tag);
            return;
        }
        Tag tagInList = tagList.get(position);
        tagInList.setFrequency(tagInList.getFrequency() + 1);
    }

    private Tag[] castListToArray() {
        Tag[] tagsFromObjectList = new Tag[tagList.getSize()];
        for (int i = 0; i < tagList.getSize(); i++) {
            tagsFromObjectList[i] = tagList.get(i);
        }
        return tagsFromObjectList;
    }

    public Tag[] getFrequencyDesc() {
        Tag[] castedTagList = this.castListToArray();
        AbstractSort<Tag> optimizedBubbleSort = new OptimizedBubbleSort<>(castedTagList);
        optimizedBubbleSort.sort();
        return castedTagList;
    }

    public boolean checkStackIsEmpty() {
        if (!tagStack.isEmpty()) {
            Tag current = tagStack.pop();
            StringBuilder message = new StringBuilder("Sequência de tags inválidas! ");

            while (current != null) {
                message.append("A tag ")
                        .append(current.getContent())
                        .append(" é inválida! Existe uma tag para fechar ainda! A tag esperada é ")
                        .append(current.getContent().replace("<", "</")).append("\n");
                try {
                    current = tagStack.pop();
                } catch (Exception e) {
                    current = null;
                }
            }
            throw new IllegalTagsSequence(message.toString());
        }
        return true;
    }
}
