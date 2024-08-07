from hexdoc.patchouli.page import PageWithTitle


class ExamplePage(PageWithTitle, type="hexcasted:example"):
    """This is the Pydantic model for the `hexcasted:example` page type."""

    example_value: str
