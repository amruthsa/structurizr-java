# Changelog

## 2.0.0 (unreleased)

- Removes deprecated concepts (e.g. location and enterprise).
- structurizr-core: Adds `Workspace.trim()` to trim a workspace of unused elements (i.e. those not associated with any views).
- structurizr-client: Removes `StructurizrClient` (use `WorkspaceApiClient` instead).
- structurizr-import: Adds support for importing decisions managed by Log4brains.
- structurizr-import: Adds support for importing decisions in MADR format.
- structurizr-dsl: Adds `!decisions` as a synonym for `!adrs`.
- structurizr-inspection: Initial version.