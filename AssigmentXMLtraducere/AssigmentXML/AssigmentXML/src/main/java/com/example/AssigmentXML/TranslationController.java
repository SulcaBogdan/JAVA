package com.example.AssigmentXML;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@RestController
public class TranslationController {
    private static final String TRANSLATIONS_XML = "translations.xml";

    @GetMapping("/translate")
    public String translate(@RequestParam String word,
                            @RequestParam String source,
                            @RequestParam String target) throws IOException, SAXException, ParserConfigurationException {
        ClassPathResource translationsXml = new ClassPathResource(TRANSLATIONS_XML);
        try (InputStream inputStream = translationsXml.getInputStream()) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);
            NodeList translationNodes = document.getElementsByTagName("translation");
            for (int i = 0; i < translationNodes.getLength(); i++) {
                Node translationNode = translationNodes.item(i);
                if (translationNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element translationElement = (Element) translationNode;
                    String translationSource = translationElement.getAttribute("source");
                    String translationTarget = translationElement.getAttribute("target");
                    if (translationSource.equals(source) && translationTarget.equals(target)) {
                        NodeList wordNodes = translationElement.getElementsByTagName("word");
                        for (int j = 0; j < wordNodes.getLength(); j++) {
                            Node wordNode = wordNodes.item(j);
                            if (wordNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element wordElement = (Element) wordNode;
                                String wordSource = wordElement.getAttribute("source");
                                if (wordSource.equals(word)) {
                                    return wordElement.getTextContent();
                                }
                            }
                        }
                    }
                }
            }
            return "Translation not found";
        }
    }
}
